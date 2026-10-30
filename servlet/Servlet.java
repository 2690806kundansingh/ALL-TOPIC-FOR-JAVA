/*
1.What is Servlet?
A Servlet is a Java program that runs on a server and handles requests from the client and sends a response back.
Example ->When you enter:
Username: Kundan
Password: 1234
Servlet can receive this data, check it, and respond:

2.Why do we use Servlet?
We use Servlets to handle requests and responses on the server side.
Servlets can be used for:
Login
Registration
Form submission
Fetching data
Sending data
Database operations
Generating dynamic responses

3.What is Servlet Container?
A Servlet Container is a part of the web server that manages Servlets.
It takes care of:
Creating Servlet objects
Calling Servlet methods
Handling requests
Sending responses
Managing Servlet lifecycle
Example:
Tomcat is a very popular Servlet Container.
-<Servlet Container is responsible for managing the lifecycle of Servlets and handling client requests and responses.

4.What is HttpServlet?
HttpServlet is a Java class used to create HTTP-based Servlets.
Instead of implementing everything ourselves, we normally extend HttpServlet.
HttpServlet is an abstract class that provides methods like doGet() and doPost() to handle HTTP requests.

5.Difference between doGet() and doPost()
Both are methods of HttpServlet.
doGet() ->Used mainly to retrieve/fetch data.
doPost() ->Used mainly to send/submit data to the server.
doGet() is generally used to retrieve data, while doPost() is generally used to submit or create data.

6.What is HttpServletRequest?
HttpServletRequest is used to get information/data sent by the client to the server.
Request can contain:
Form data
Query parameters
Headers
Cookies
Request information

7.What is HttpServletResponse?
HttpServletResponse is used to send a response from the server back to the client.
You can use response to send:
Text
HTML
JSON
Status codes
Headers
Redirects
Simple flow:

8.Difference between ServletConfig and ServletContext
ServletConfig is used for configuration of a specific Servlet, whereas ServletContext
 is used to share information across the entire web application.

9.Who manages the Servlet lifecycle?
The Servlet Container manages the Servlet lifecycle.
Tomcat
  ↓
Creates Servlet
  ↓
init()
  ↓
service()
  ↓
doGet()/doPost()
  ↓
destroy()
Tomcat decides when these methods should be called.

->What each method does:
1. init()
→ Called once when Servlet is initialized.

2. service()
→ Receives and processes requests.

3. doGet()
→ Handles GET requests.

4. doPost()
→ Handles POST requests.

5. destroy()
→ Called when Servlet is being removed/shut down.

Servlet lifecycle is managed by the Servlet Container and consists mainly of initialization, 
request processing, and destruction using methods like init(), service(), and destroy().


10.What is URL Mapping?
URL mapping tells Tomcat,Which Servlet should handle which URL?
There are two common ways to do this:
@WebServlet annotation ⭐
web.xml

Easy difference:
@WebServlet----	web.xml
Annotation-----	XML configuration
Written in Java class-----	Written in web.xml
Easy and modern	----Older/traditional approach
Less configuration----	More configuration

11.How do you create a Servlet?
We create a Java class that extends HttpServlet and override methods such as doGet() or doPost().

==> What is @WebServlet?
@WebServlet is an annotation used to map a URL to a Servlet.

==> What is web.xml?
web.xml is the deployment descriptor used to configure a web application, including Servlet mappings.

==>. How do you get data from a request?
request.getParameter("name");

==>What does response.getWriter() do?
It is used to write/send text response to the client.

==================how one Servlet can communicate with another Servlet/page.=============

12.What is RequestDispatcher?
RequestDispatcher is used to send a request from one Servlet to another resource such as another Servlet, JSP, or HTML page.
It mainly provides two methods:
forward()
include()

==>What is forward()?
forward() transfers the request from one Servlet to another resource on the server side.

==>What is include()?
include() is used when you want to include the output of another resource in the current response.

==>What is sendRedirect()?
sendRedirect() tells the browser to make a new request to another URL.

==>forward() vs sendRedirect()
forward()	--- sendRedirect()
Server-side	----Client/browser-side
Same request----	New request
URL does not change	-----URL changes
Faster generally	----Slightly more overhead because of new request
Uses RequestDispatcher	-----Uses response.sendRedirect()
Request data can be passed directly	---Original request data is not carried to the new request

forward() is server-side and uses the same request, while sendRedirect() is client-side and creates a new request.


==>Request Attributes
When using forward(), you can send additional data using request attributes.

=====================Session Management in Servlet============
Today we will learn Cookies, HttpSession, URL Rewriting, and how to maintain user information between multiple requests.

13.What is Session Management?
Session Management is a technique used to remember a user's information across multiple requests.
1. Cookies
2. HttpSession ⭐
3. URL Rewriting
4. Hidden Form Fields

==>What is a Cookie?
A Cookie is a small piece of information stored in the user's browser by the server.
The browser sends the cookie back with later requests.

14.What is HttpSession?
HttpSession is used to store user-specific information on the server across multiple requests.

==>What does invalidate() do?
It destroys the current session.
So the user is logged out.

==>What is URL Rewriting?
URL Rewriting means adding session information to the URL.


15.Cookies vs HttpSession
Cookie-----	HttpSession
Stored in browser/client------	Data stored on server
Small amount of data-------	Can store more application data
Client-side--------	Server-side
Can have expiration time	------Session has lifecycle/timeout
User can potentially modify cookie data-------	Session attributes are maintained server-side

==>What is Session ID?
When a session is created, the server/container gives it a unique session ID.
The browser can send this ID back with future requests so the server can identify the session.

==>What is JSESSIONID?
JSESSIONID is a session identifier used by the Servlet Container to identify a user's HttpSession.

==>Session Timeout
A session should not stay active forever.

==>Hidden Form Fields
Another session-tracking technique is using hidden fields in HTML.
The user doesn't see the field, but its value is submitted with the form.



====================Servlet + HTML Form + JDBC + Database==========
Today we connect Servlet with a Database.

16.Why connect Servlet with Database?
->A Servlet can receive data from a user, but if we want to save that data permanently, we need a database.


====================Filters, Listeners & ServletConfig/ServletContext============

1.what is Filter ?
A Filter is used to perform some common work before or after a request reaches a Servlet.
Think of a filter as a security/checking gate.
Browser
   ↓
 Filter
   ↓
 Servlet
   ↓
 Response

 ==>What is chain.doFilter()?
 Allow the request to continue to the next filter or Servlet.
Request
   ↓
Filter
   ↓
chain.doFilter()
   ↓
Servlet
If we don't call it, the request can be stopped.

==>Common Uses of Filters
Filters are commonly used for:
Authentication
Authorization
Logging
Request validation
Character encoding
Security checks

==>What is a Servlet Listener?
A Listener listens for specific events happening inside a web application.
Session Created
Session Destroyed
Application Started
Application Stopped

==>Common Servlet Listeners
.HttpSessionListener
  Listens for:
  Session Created
  Session Destroyed
.ServletContextListener
 Listens for:
 Application Started
 Application Stopped

.ServletRequestListener
 Listens for:
 Request Created
 Request Destroyed


==> what is ServletConfig?
 ServletConfig is used to provide configuration information to one specific Servlet.
 Example:
 LoginServlet
    ↓
ServletConfig
    ↓
Admin

Only LoginServlet gets this configuration.

==>What is ServletContext?
ServletContext provides information that can be shared across the entire web application.

==>ServletConfig vs ServletContext
ServletConfig	---ServletContext
For one Servlet	----For whole application
Servlet-specific configuration	-----Application-wide information
Each Servlet can have its own Config-----	Generally one Context per web application
Used with init parameters	-----Used for shared attributes/configuration
 */