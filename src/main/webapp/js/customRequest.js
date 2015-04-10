function ajaxRequest(url) {
	var retorno = '';
	$.ajax({
		url : url,
		async : false,
		success : function(result) {
			retorno = result.value;
		}
	});

	return retorno;
}

function ajaxRequestWithoutValue(url) {
	var retorno = '';
	$.ajax({
		url : url,
		async : false,
		success : function(result) {
			retorno = result;
		}
	});

	return retorno;
}



function ajaxRequestWithoutValueJsonp(url) {
	var retorno = '';
	$.ajax({
		url : url,
		async : false,
		success : function(result) {
			retorno = result;
		}
	});

	return retorno;
}
function ajaxRequestJson(url) {
	var retorno;
	$.ajax({
		url : url,
		async : false,
		success : function(result) {
			retorno = result.value;
		}
	});
	
	return retorno;
}

function ajaxRequestToArray(url) {
	return ajaxRequest(url).split(',');
}

function loadAnalyticsStats(period, status, graphSize, data1, data2) {
	return ajaxRequest('analytics/list/analyticsStats/'
			+ period + '/' + status + '/' + graphSize + '/'
			+ data1.replace(/\//g, '-') + '/' + data2.replace(/\//g, '-'));
}

function loadAnalyticsMorrisStats(period, status, graphSize, data1, data2) {
	return ajaxRequest('analytics/list/analyticsMorrisStats/'
			+ period + '/' + status + '/' + graphSize + '/'
			+ data1.replace(/\//g, '-') + '/' + data2.replace(/\//g, '-'));
}

	
function getMorrisGraphBarAnalyticsData() {
	var a = ajaxRequestWithoutValueJsonp('shippingSumary/sumarySent/');
	return a;
}

function getMorrisVideoGraphAnalyticsData() {
	var a = ajaxRequestWithoutValue('department/sumarySent/');
	return a;
}

