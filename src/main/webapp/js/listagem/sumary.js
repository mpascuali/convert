
window.Morris.Donut.prototype.setData = function(data, redraw) {
	if (redraw == null) {
		redraw = true;
	}
	this.data = data;
	this.values = (function() {
		var _i, _len, _ref, _results;
		_ref = this.data;
		_results = [];

		for (_i = 0; _i < _ref.aaData.length; _i++) {
			row = {
				value : parseInt(_ref.aaData[i].totalVote),
				label : _ref.aaData[i].category
			};
			_results.push(row);

		}
		return _results;
	}).call(this);
	this.dirty = true;
	if (redraw) {
		return this.redraw();
	}
}

var fullJson = getMorrisVideoGraphAnalyticsData();

var jsonMorrisVideo = fullJson;

//var jsonMorrisVideo = getMorrisGraphBarAnalyticsData();


var graphBar = getMorrisGraphBarAnalyticsData();	
var graphBarKeys = [];
				
jsonMorrisVideo = getSpecificMorrisVideoGraphDataAnalytics(jsonMorrisVideo);
graphBar = getSpecificMorrisGraphDataAnalytics(graphBar);



function getSpecificMorrisVideoGraphDataAnalytics(dtt) {
	var res = [];
	for ( var i = 0; i < dtt.aaData.length; ++i) {
		var row = {
			value : parseInt(dtt.aaData[i].totalSent),
			label : dtt.aaData[i].name
		};
		res.push(row);
	}

	return res;
}

function getSpecificMorrisGraphDataAnalytics2(dtt) {
	var res = [];

	for ( var i = 0; i < dtt.keyValues.length; ++i) {
		var myDate = new Date(dtt.keyValues[i].referenceDate);
		var aa = myDate.getFullYear() + "-" + myDate.getMonth() + 1 + "-"+ myDate.getDate();
		res.push({
			date : (aa),
			a : (dtt.keyValues[i].value),
			b : (dtt.keyValues[i].value),
			c : (dtt.keyValues[i].value)

		});
	}

	return res;
}

var depart = [];
function getSpecificMorrisGraphDataAnalytics(dtt) {
	depart = dtt.departments; 
	return dtt;
}




function getDepartmentLabels(dtt) {
	var res = [];

	for ( var i = 0; i < dtt.aaData.length; ++i) {
		res.push(dtt.aaData[i].name);
	}
	return res;
}

var graphTotal = Morris.Donut({
	element : 'graph-totalVote',
	data : jsonMorrisVideo,
});



var morrisGraphLine = Morris.Bar({		
	  element: 'graphBar',	
	  data: graphBar.values,	
	  xkey: 'date',	
	  ykeys: graphBar.departments,	
	  xLabels:'day',	
	  hideHover: true,
	  labels: graphBar.departments,
	  dateFormat: function(date) {
          d = new Date(date);
          return d.getDate()+'/'+(d.getMonth()+1)+'/'+d.getFullYear(); 
          },
	});	

var nReloads = 0;
function update() {
	nReloads++;
	  var j = getSpecificMorrisGraphDataAnalytics(getMorrisGraphAnalyticsData());
	  morrisGraphLine.setData(j);
	var k = getSpecificMorrisVideoGraphDataAnalytics(getMorrisVideoGraphAnalyticsData());
	graphTotal.setData(k, null);
	$('#reloadStatus').text(nReloads + ' reloads');
}

//setInterval(update, 30000);

//$(function() {
//	eval($('#code').text());
//	prettyPrint();
//});
