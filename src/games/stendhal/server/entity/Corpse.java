/* $Id$ */
/***************************************************************************
 *                      (C) Copyright 2003 - Marauroa                      *
 ***************************************************************************
 ***************************************************************************
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU General Public License as published by  *
 *   the Free Software Foundation; either version 2 of the License, or     *
 *   (at your option) any later version.                                   *
 *                                                                         *
 ***************************************************************************/
package games.stendhal.server.entity;

import marauroa.common.*;
import marauroa.common.game.*;
import marauroa.server.game.*;
import games.stendhal.common.*;
import games.stendhal.server.*;
import java.awt.*;
import java.awt.geom.*;


public class Corpse extends Entity
  {
  final private int DEGRADATION_TIMEOUT=180;
  private int degradation;
  
  public Corpse(RPObject object) throws AttributeNotFoundException
    {
    super(object);
    update();
    }

  public Corpse(RPEntity entity) throws AttributeNotFoundException
    {
    put("type","corpse");
    setx(entity.getx());
    sety(entity.gety());
    degradation=DEGRADATION_TIMEOUT;
    }
  
  public int getDegradation()
    {
    return degradation;
    } 
  
  public int decDegradation()
    {
    return degradation--;
    }
  }
