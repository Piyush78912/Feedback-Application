<!doctype html>
<html lang="en">
  <head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap Demo</title>
    
    <%@ include file="links.jsp" %>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" />
  </head>
  <body>
    <%@ include file="header.jsp" %>
    <div class="content_container py-4 d-flex flex-column justify-content-center align-items-center">
      <h3 class="text-white">Fill the feedback form:</h3>
      
      <form action="<%=application.getContextPath() %>/feedback" method="post" class="mt-3 text-white">
      
        <!-- Email field -->
        <div class="mb-3">
          <label for="email" class="form-label">Email address</label>
          <input placeholder="Enter here" name="email" type="email" class="form-control" id="email" aria-describedby="emailHelp">
          <div id="emailHelp" class="form-text text-white">We'll never share your email with anyone else.</div>
        </div>
        
        <!-- Phone number field -->
        <div class="mb-3">
          <label for="phone" class="form-label">Phone number</label>
          <input placeholder="Enter here" name="phone" type="text" class="form-control" id="phone">
        </div>
        
        <!-- Feedback message field -->
        <div class="mb-3">
          <label for="feedback" class="form-label">Your feedback Message</label>
          <textarea name="feedback_message" rows="10" placeholder="Enter here" class="form-control" id="feedback" cols="30"></textarea>
        </div>
        
        <div class="container text-center">
          <button type="submit" class="btn btn-warning">Submit</button> 
          <button type="reset" class="btn btn-light">Reset</button>
        </div>
      </form>
    </div>
    
    <%@ include file="scripts.jsp" %>
  </body>
</html>
