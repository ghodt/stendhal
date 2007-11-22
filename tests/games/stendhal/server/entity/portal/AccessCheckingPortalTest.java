package games.stendhal.server.entity.portal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import games.stendhal.server.StendhalRPZone;
import games.stendhal.server.entity.Entity;
import games.stendhal.server.entity.RPEntity;
import games.stendhal.server.entity.player.Player;
import games.stendhal.server.entity.portal.AccessCheckingPortal.SendMessage;
import games.stendhal.server.events.TurnListener;
import games.stendhal.server.events.TurnNotifier;
import games.stendhal.server.maps.MockStendlRPWorld;

import java.util.Set;

import marauroa.common.Log4J;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.PlayerTestHelper;

public class AccessCheckingPortalTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Log4J.init();
		Entity.generateRPClass();
		Portal.generateRPClass();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {

	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		TurnNotifier.get().getEventListForDebugging().clear();
		assertTrue(TurnNotifier.get().getEventListForDebugging().isEmpty());
	}

	@Test
	public final void testAccessCheckingPortal() {
		new MockAccessCheckingPortal();
	}

	@Test
	public final void testOnUsed() {
		AccessCheckingPortal port = new MockAccessCheckingPortal();
		Object ref = new Object();
		port.setDestination("zonename", ref);
		Portal destPort = new Portal();
		destPort.setIdentifier(ref);
		StendhalRPZone zone = new StendhalRPZone("zonename");
		zone.add(destPort);
		MockStendlRPWorld.get().addRPZone(zone);

		Player player = PlayerTestHelper.createPlayer("mayNot");
		assertFalse(port.onUsed(player));

		player = PlayerTestHelper.createPlayer("may");
		assertTrue(port.onUsed(player));
	}

	@Test
	public final void testIsAllowed() {
		AccessCheckingPortal port = new MockAccessCheckingPortal();
		Player player = PlayerTestHelper.createPlayer("may");
		assertTrue(port.isAllowed(player));
		player = PlayerTestHelper.createPlayer("mayNot");
		assertFalse(port.isAllowed(player));
	}

	@Test
	public final void testRejected() {
		AccessCheckingPortal port = new MockAccessCheckingPortal();
		Player player = PlayerTestHelper.createPlayer("mayNot");
		port.rejected(player);
		Set<TurnListener> bla = TurnNotifier.get().getEventListForDebugging().get(
				Integer.valueOf(0));
		TurnListener[] listenerset = new TurnListener[bla.size()];
		bla.toArray(listenerset);
		assertTrue(listenerset[0] instanceof AccessCheckingPortal.SendMessage);
		SendMessage sm = (SendMessage) listenerset[0];
		sm.onTurnReached(0);
		assertEquals("rejected", player.get("private_text"));

	}

	@Test
	public final void testSetRejectedMessage() {
		AccessCheckingPortal port = new MockAccessCheckingPortal();
		Player player = PlayerTestHelper.createPlayer("mayNot");
		port.setRejectedMessage("setRejectMessage");
		port.rejected(player);
		Set<TurnListener> bla = TurnNotifier.get().getEventListForDebugging().get(
				Integer.valueOf(0));
		TurnListener[] listenerset = new TurnListener[bla.size()];
		bla.toArray(listenerset);
		assertTrue(listenerset[0] instanceof AccessCheckingPortal.SendMessage);
		SendMessage sm = (SendMessage) listenerset[0];
		sm.onTurnReached(0);
		assertEquals("setRejectMessage", player.get("private_text"));
	}

	class MockAccessCheckingPortal extends AccessCheckingPortal {

		public MockAccessCheckingPortal() {
			super("rejected");

		}

		@Override
		protected boolean isAllowed(RPEntity user) {
			return "may".equals(user.getName());

		}

	}
}
