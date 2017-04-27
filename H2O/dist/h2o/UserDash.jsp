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
	<script src="js/enquire.min.js"></script>
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
	
    <div class="container-fluid">
      <div class="row" >
        <div class="col-md-3 tab" id="tab1">
          <div class="sec-hd">Alerts</div>
		  <div class="alert-details-hd">
				<!--<div class="circle alertIndi">2</div> -->
				<div class="glyphicon glyphicon-bell"></div>
				<span id="alert_header"></span>
		  </div>
		  <div>
		  <!--<div style="color:green;">No leak detected</div> -->
			  <span class="glyphicon glyphicon-triangle-left alert-arrow" id="prev_alert"></span>
				<span id="alert_detail"></span>
			  <span class="glyphicon glyphicon-triangle-right alert-arrow" id="next_alert"></span>
		  </div>
        </div>
		

  
		
		
        <div class="col-md-9 tab" id="tab2">
		<div class="sec">
          <div class="sec-hd">At a Glance</div>
			<div class="row">
				<div class="col-md-2 usage-indicator">
				<div class="glyphicon glyphicon-arrow-up"></div>
				</div>
				<div  class="col-md-3 usg-tab">
					<div class="usage-data row"><div class="col-xs-4 qty high" id="last7DayUse">2,098</div> <div class="col-xs-6">Last 7 Day<div class="unit">gallon</div></div><div class="col-xs-1"><span class="graph-color" style="background-color:rgb(26,29,182);"></span></div></div>
					<div class="usage-data row"><div class="col-xs-4 qty" id="prev7DayUse">1,997</div> <div class="col-xs-6">Prev 7 days<div class="unit">gallon</div></div><div class="col-xs-1"><span class="graph-color" style="background-color:rgb(151,187,205);"></span></div></div>
					<div class="usage-data row"><div class="col-xs-4 qty"  id="monthAvg">314</div> <div class="col-xs-6">30 day avg<div class="unit">gallon per day</div></div></div>
				</div>
				<div class="col-md-7">
						<canvas id="seven-day" height = "300px" style="height:300px;"></canvas>
				</div>
			</div>
			</div>
      </div>
    </div>
	<div class="row">
	<div class="col-md-3 tab" id="tab3" style="text-align:center;">
          <div class="sec-hd">Your meter</div>
		  <div class="met-cur-consumption">Current Consumption : <span id="curMonthConsum">1,200</span> Litres</div><div class="met-usg-indi more" id="usgIndi"><div class="glyphicon glyphicon-bell"></div> 32% <div class="glyphicon glyphicon-arrow-up"></div></div>
		  
		  <div ><div class="circle">Unbilled amount <div>Rs <span  class="met-unbilled-amt" id="unbilledAmt">1,200</span></div></div></div>
		  <div class="row met-amts">
		  <div class="col-xs-6">Last Bill Amount <div class="met-amt">Rs <span id="lastBill">1,481</span></div></div>
		  <div class="col-xs-6">Predicted Bill <div class="met-amt">Rs <span id="predictedBill">1,921</div></div>
		  </div>
	</div>
	<div class="col-md-9 tab" id="tab4">
	<div>
		<div class="group-by">
		<span>Hour</span><span>Day</span><span class="selected">Month</span><span>Year</span>
		<span class="glyphicon glyphicon-triangle-left"></span><span>Today</span><span class="glyphicon glyphicon-triangle-right"></span>
		<span class="glyphicon glyphicon-calendar"></span>
		</div>
	</div>
		<canvas id="monthly" height="450" width="600"></canvas>
	</div>
	</div>
	
	<div class="row phone-tabs">
	<a class="col-xs-3" onclick="goTo('tab1');">Alert</a>
	<a class="col-xs-3" onclick="goTo('tab2');">Overview</a>
	<a class="col-xs-3" onclick="goTo('tab3');">Meter</a>
	<a class="col-xs-3" onclick="goTo('tab4');">History</a>
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
	var data = {
			"curSevenDayUsage" : [1000,2067,2298,1020,3040,2000,1000],
			"prevSevenDayUsage" : [2000,1067,1298,3020,2040,1000,2000],
			"monthlyData" : [2000,1067,1298,3020,2040,1000,2000,3020,2040,1043],
			last7Day :  2345,
			prev7Day : 1735,
			avg30Days : 323,
			curConsumption : "1,250",
			usgDelta : "30",//in percentage
			unbilledAmt : 456,
			lastBill : 444,
			predictedBill : 657,
			"alerts" : [
			 	{"message" : "Overflow","detail" : "Bathroom : Running water detected from bathroom tap for last 40 min.Please check!!!<div style='padding-top:15px;'>Would you like to shut water supply</div>"},
				{"message" : "Broken Pipe","detail" : "Possible leak detected Your garden sprinkler is consuming 20 Liters per minute.More than usual!!!!<div style='padding-top:15px;'>Check for broken pipe in lawn irrigation system.</div>"}
			]
			
			};


	var currSeven = data["curSevenDayUsage"];
	var prevSeven = data["prevSevenDayUsage"];
	//monthly Data would need to be updated with yearly/monthly/daily data from backend
	var monthlyData = data["monthlyData"];
	var SevenDayScaleStart = (Math.min(...currSeven) > Math.min(...prevSeven) ? Math.min(...prevSeven) : Math.min(...currSeven)) - 350;
	var scaleStep = function(arr){
		return Math.ceil(Math.max(...arr)/15);
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
			scaleSteps:15,
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
		populateAlerts();
enquire.register("screen and (max-width: 768px)", {
match : function(){
		$(".tab").hide();
		$("#tab1").show();},
unmatch : function(){
		$(".tab").show();
}

});
	}
 
	var sevenDayChartData = {
		labels : getWeek(),
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

function goTo(tab){
	//hide all
	$(".tab").hide();
	//show tab
	$("#" + tab).show();
	return false;
}
function populateAlerts(){
	var counter = 0,header = "",detail = "",alert={};
	for (var index in data["alerts"]) {
		counter++;
		alert = data["alerts"][index];
		header += '<span id="alert_'+ counter +'" class="alert '+(counter == 1 ? 'shown' : '')+'">Alert '+ counter +' : '+ alert.message +'</span>';
		detail += '<div id="alert-det_'+counter+'" class="alert-det '+(counter == 1 ? 'shown' : '')+'">'+alert.detail+'</div>';
		}
	$('#alert_header').html(header);
	$('#alert_detail').html(detail);
	
	$("#last7DayUse").html(data.last7Day);
	$("#prev7DayUse").html(data.prev7Day);
	$("#monthAvg").html(data.avg30Days);
	$("#curMonthConsum").html(data.curConsumption);
	if(data.usgDelta < 0){
		$("#usgIndi").html('<div class="glyphicon glyphicon-bell"></div> '+ data.usgDelta +'% <div class="glyphicon glyphicon-arrow-up"></div>').addClass("more");
	}else{
		$("#usgIndi").html(data.usgDelta +'% <div class="glyphicon glyphicon-arrow-down"></div>').removeClass("more");
	}
	$("#unbilledAmt").html(data.unbilledAmt);
	$("#lastBill").html(data.lastBill);
	$("#predictedBill").html(data.predictedBill);
	
}

  
	</script>
	<div class="footer"><a href="#">Contact Us</a> <a href="#">How it works</a><div style="padding-top: 10px;">© 2014 H2O Works.</div></div>
  </body>
</html>
