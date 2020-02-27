package com.revature.queries;

import java.util.ArrayList;

public interface Query {
public abstract boolean insertToTable(String query);

public abstract boolean updateTable(String query);

public abstract ArrayList selectFromTable(String query);

public abstract boolean deleteFromTable(String query);

}
