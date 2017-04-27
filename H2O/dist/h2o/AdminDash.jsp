<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>H20</title>

    <!-- Bootstrap core CSS -->
    <link href="dist/css/bootstrap.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/dashboard.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="../../assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	<script src="js/Chart.js"></script>
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">H2O,Save water Save world</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
        </div>
      </div>
    </nav>

		<h1 class="page-header">Dashboard-Measure what matters</h1>
	<div style="padding:10px 0 15px 0;text-align:center;font-size:16px;">
		<span style="padding-right:10px;font-weight: bold;">Area</span>
		<select style="padding:5px;"><option selected>Sector 31</option><option>Sector 25</option></select>
	</div>
    <div class="container-fluid">
	<div class="row" >
        <div class="col-md-3 tab" id="tab1">
          <div class="sec-hd">Alerts</div>
		  <div class="alert-details-hd">
				<!--<div class="circle alertIndi">2</div> -->
				<div class="glyphicon glyphicon-bell"></div>
			  <span id="alert_1" class="alert shown">Alert 1 : Overflow</span>
			  <span id="alert_2"  class="alert">ALert 2 : Broken Pipe</span>
		  </div>
		  <div>
		  <!--<div style="color:green;">No leak detected</div> -->
			  <span class="glyphicon glyphicon-triangle-left alert-arrow" id="prev_alert"></span>
			  <div id="alert-det_1" class="alert-det shown">
				Water flowing at G212 at 100 l/min .Its avg flow is 50 l/min
				<div style="padding-top:15px;">Would you like to shut water supply</div>
				</div>
			  <div id="alert-det_2" class="alert-det">
				  Tank Overflow/Broken Pipe
				  Water outflow at B-21 ,Sec 31 ,Noida is same as inflow.
				  <div style="padding-top:15px;">Check for broken pipe</div>
			  </div>
			  <span class="glyphicon glyphicon-triangle-right alert-arrow" id="next_alert"></span>
		  </div>
		 
        </div>
		

  
		
		
        <div class="col-md-9 tab" id="tab2">
		<div class="sec">
          <div class="sec-hd">At a Glance</div>
		  <div class="row">

				<div class="col-md-5" >	
					<div class="usage-data row"><div class="col-xs-4 qty high">12,098</div> <div class="col-xs-6">Used This Month<div class="unit">gallon</div></div><div class="col-xs-1"><span class="graph-color" style="background-color:rgb(26,29,182);"></span></div></div>
					<div class="usage-data row"><div class="col-xs-4 qty">11,997</div> <div class="col-xs-6">Predicted Usage<div class="unit">gallon</div></div><div class="col-xs-1"><span class="graph-color" style="background-color:rgb(151,187,205);"></span></div></div>
					<div class="usage-data row"><div class="col-xs-4 qty">1314</div> <div class="col-xs-6">Last Month Usage<div class="unit">gallon per day</div></div></div>
				</div>
				<div class="col-md-7" style="font-weight: bold;text-align: center;">
				Six month Usage Pattern of Area
						<canvas id="seven-day" height = "300px" style="height:300px;"></canvas>
				</div>
			</div> 
			</div>
      </div>
    </div>
	<div class="tab" id="tab3">
     <div class="sec-hd" style="margin-top:20px;">Usage Metrics</div>
	<div class="row">
	
	<div class="col-md-6"  style="text-align:center;">
         
		  
		  <img src="img/water_points.png" width="100%"/>
		  </div>
	
	<div class="col-md-6 ">
	<div><span style="font-weight:bold;">Address : </span>A - 131 , Sector 31 ,Noida </div><div><div class="glyphicon glyphicon-bell" style="color:#AA1A12;"></div><span style="font-weight:bold;color:#AA1A12;">Alerts given : </span>Bathroom Leakage!!!</div>
	<div>
		<div class="group-by">
		<span>Hour</span><span class="selected">Day</span><span>Month</span><span>Year</span>
		<span class="glyphicon glyphicon-triangle-left"></span><span>Today</span><span class="glyphicon glyphicon-triangle-right"></span>
		<span class="glyphicon glyphicon-calendar"></span>
		</div>
	</div>

		<canvas id="monthly" height="400"></canvas>
	</div>
	</div>

	</div>
		<div class="row phone-tabs">
	<a class="col-xs-4" onclick="goTo('tab1');">Alert</a>
	<a class="col-xs-4" onclick="goTo('tab2');">Overview</a>
	<a class="col-xs-4" onclick="goTo('tab3');">Metrics</a>
	</div>
	</div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="assets/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="assets/js/ie10-viewport-bug-workaround.js"></script>
	<script>
	var currSeven = [1000,2067,2298,1020,3040,2000,1000];
	var prevSeven = [2000,1067,1298,3020,2040,1000,2000];
	//monthly Data would need to be updated with yearly/monthly/daily data from backend
	var monthlyData = [2000,1067,1298,3020,2040,1000,2000,3020,2040,1043];
	var SevenDayScaleStart = (Math.min(...currSeven) > Math.min(...prevSeven) ? Math.min(...prevSeven) : Math.min(...currSeven)) - 350;
	var scaleStep = function(arr){
		return Math.ceil(Math.max(...arr)/10);
	}
	var today = new Date;
	function getDaysInMonth(month,year) {  
		// Here January is 1 based  
		//Day 0 is the last day in the previous month  
		 var daysAr = [];
		 var numberOfDays = new Date(year, month, 0).getDate();  
			for(x=1;x<=numberOfDays;x++ ){
			daysAr.push(x);
		}
		return daysAr;
	} 
	var monthlyChartData = {
		//labels : ["1",'2','3','4',"5","10","15","20","25","30"],
		labels : getDaysInMonth(today.getMonth() +1,today.getYear()),
		datasets : [
			{
				fillColor : "rgba(220,220,220,0.5)",
				strokeColor : "rgba(220,220,220,0.8)",
				highlightFill: "rgba(220,220,220,0.75)",
				highlightStroke: "rgba(220,220,220,1)",
				data : monthlyData 
			}
			]

	}

	window.onload = function(){
		var monthly = document.getElementById("monthly").getContext("2d");
		window.myBar = new Chart(monthly).Bar(monthlyChartData, {
			responsive : true,
			scaleOverride:true,
			scaleSteps:10,
			scaleStepWidth:scaleStep(monthlyChartData.datasets[0].data),
			maintainAspectRatio: false,
		});
		var sevenDay = document.getElementById("seven-day").getContext("2d");
		window.myBar = new Chart(sevenDay).Bar(sevenDayChartData, {
			responsive : true,
			scaleOverride:true,
			scaleShowGridLines : false,
			scaleSteps:10,
			scaleStepWidth:400,
			maintainAspectRatio: false,
			//scaleStartValue: SevenDayScaleStart
		});
		$('#next_alert').click(function(e){ 
			changealert(1);
		});                                   
 
		$('#prev_alert').click(function(e){  
			changealert(-1);
		}); 
	}
 
	var sevenDayChartData = {
		labels : ['Jan','Feb','Mar','Apr','May','Jun'],
		datasets : [
			{
				fillColor : "rgba(26,29,182,0.5)",
				strokeColor : "rgba(26,29,182,0.5)",
				highlightFill: "rgba(26,29,182,0.75)",
				highlightStroke: "rgba(26,29,182,1)",
				data : currSeven
			},
			{
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,0.5)",
				highlightFill : "rgba(151,187,205,0.75)",
				highlightStroke : "rgba(151,187,205,1)",
				data : prevSeven
			}
		]

	}


function getWeek(){
	var weekday = new Array(7);
	weekday[0]=  "Sun";
	weekday[1] = "Mon";
	weekday[2] = "Tue";
	weekday[3] = "Wed";
	weekday[4] = "Thu";
	weekday[5] = "Fri";
	weekday[6] = "Sat";
	weekAr = [];
	for(x=today.getDay();x<7;x++){
		weekAr.push(weekday[x]);
		if(x==6 && weekAr.length<7){
			x=-1;
		}
		if(weekAr.length==7){
			return weekAr;
		}
	}
	return;
}

		function changealert(counter){
			var banVis = $(".alert.shown");
			if( banVis!= null){
				var showBanNum = parseInt(banVis[0].id.split("_")[1])+ counter;
				if($(".alert").length < showBanNum && counter == 1){
					showBanNum = 1;
				}
				if(counter == -1 && showBanNum < 1 ){
					showBanNum = $(".alert").length ;
				}
				banVis.removeClass("shown");
				$(".alert-det.shown").removeClass("shown");
				$("#alert_"+ showBanNum).addClass("shown");
				$("#alert-det_"+ showBanNum).addClass("shown");
			}
			  return false;
		}


  
	</script>
  </body>
</html>
