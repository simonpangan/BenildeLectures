<%@page import="java.util.*" %>

<html>

<body>

<!-- Step 1 : Create HTML form -->
<form action="things-to-buy2.jsp">
	Add New Item: <input type="text" name="theItem" />
	
	<input type="submit" value="submit" />

</form>

<br/>
Item Entered : <%= request.getParameter("theItem") %>

<!-- Step 2 : Add new item to "To Do" list -->
<%
	
	// get the TO DO items from the session
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	
	// if the TO DO items doesn't exist, then create a new one.
	if (items == null)
	{
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}

	// see if there is form data to add
	String theItem = request.getParameter("theItem");
	
	
	if(theItem != null && (!theItem.trim().equals("")))
	{
		items.add(theItem);
	} 
	
	/*
	boolean isItemNotEmpty = theItem != null && theItem.trim().length() > 0;
	boolean isItemNotDuplicate = theItem != null && !items.contains(theItem.trim());
	
	if (isItemNotEmpty && isItemNotDuplicate) {    		
		items.add(theItem.trim());    		
	}
	
	*/

%>


<!-- Step 3 : Display all "To Do" items from session -->

<hr>
<b>To Do List Items:</b>

<ol>
	<%
		for (String temp : items)
		{
			out.println("<li>" + temp + "</li>");
		}
		
		
	%>

</ol>

</body>

</html>