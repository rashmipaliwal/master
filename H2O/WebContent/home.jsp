<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE HTML>
<html>
  <head>
    <title>Spring MVC - Ajax</title>
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
    <style>
      body { background-color: #eee; font: helvetica; }
      #container { width: 500px; background-color: #fff; margin: 30px auto; padding: 30px; border-radius: 5px; box-shadow: 5px; }
      .green { font-weight: bold; color: green; }
      .message { margin-bottom: 10px; }
      label { width:70px; display:inline-block;}
      .hide { display: none; }
      .error { color: red; font-size: 0.8em; }
    </style>
  </head>
  <body>
  
  <div id="container">
  
    <h1>Test Home Page</h1>
    
    
    <h2>Get Consumption</h2>
    <input type="submit" id="getConsumption" value="Get Consumption" /><br/><br/>
    <div id="thingMeasureResponse"> </div>
    
    <hr/>
  </div>
  
  
  <script type="text/javascript">
  
    $(document).ready(function() {
      
   /*    // Random Person AJAX Request
      $('#getConsumption').click(function() {
        $.getJSON('${pageContext.request.contextPath}/flow/getWaterConsumptionByUser.htm', function(thingMeasure) {
          $('#thingMeasureResponse').text(thingMeasure.thingId + ', list ' + person.waterConsumptionList);
        });
      }); */      
    
      
    });
    
  </script>
  
  </body>
</html>