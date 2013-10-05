/*
 * Copyright (C) 2013      Denis Forveille titou10.titou10@gmail.com
 * Copyright (C) 2010-2013 Serge Rieder serge@jkiss.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 */
package org.jkiss.dbeaver.ext.db2.manager;

import org.jkiss.dbeaver.ext.db2.model.DB2DataType;
import org.jkiss.dbeaver.ext.db2.model.DB2Schema;
import org.jkiss.dbeaver.model.impl.DBSObjectCache;

/**
 * DB2 Data Type Manager
 * 
 * @author Denis Forveille
 */
public class DB2DataTypeManager extends DB2AbstractDropOnlyManager<DB2DataType, DB2Schema> {

    private static final String SQL_DROP = "DROP TYPE %s RESTRICT";

    @Override
    public String buildDropStatement(DB2DataType db2DataType)
    {
        String fullyQualifiedName = db2DataType.getFullQualifiedName();
        return String.format(SQL_DROP, fullyQualifiedName);
    }

    @Override
    public DBSObjectCache<DB2Schema, DB2DataType> getObjectsCache(DB2DataType db2DataType)
    {
        return db2DataType.getSchema().getUdtCache();
    }
}