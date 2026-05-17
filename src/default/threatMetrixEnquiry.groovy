def responseStr = null;

if (requestXml.toUpperCase().contains('account_name=TMTIMEOUT'.toUpperCase()))
{
		sleep 65 * 1000 //65 seconds
		
		// success
		responseStr = '''
device_id=82bff208d2e911dc800000163e3cf324&device_result=not+found&enabled_ck=yes&enabled_fl=yes&enabled_js=yes&os=Windows+NT+5.1&proxy_ip=192.168.0.154&proxy_ip_reputation=100&screen_res=1920x1200&session_anomaly=no&summary_risk_score=0&time_zone=660&true_ip=220.233.95.244&true_ip_geo=AU&event_type=payment&request_result=success&review_status=pass
'''
		
}
else if (requestXml.contains('THREATMETRIX_REVIEW'))
{
    responseStr = '''
device_id=82bff208d2e911dc800000163e3cf324&device_result=not+found&enabled_ck=yes&enabled_fl=yes&enabled_js=yes&os=Windows+NT+5.1&proxy_ip=192.168.0.154&proxy_ip_reputation=100&screen_res=1920x1200&session_anomaly=no&summary_risk_score=0&time_zone=660&true_ip=220.233.95.244&true_ip_geo=AU&event_type=payment&request_result=success&review_status=review
'''
}
else if (requestXml.contains('THREATMETRIX_REJECT'))
{
    responseStr = '''
device_id=82bff208d2e911dc800000163e3cf324&device_result=not+found&enabled_ck=yes&enabled_fl=yes&enabled_js=yes&os=Windows+NT+5.1&proxy_ip=192.168.0.154&proxy_ip_reputation=100&screen_res=1920x1200&session_anomaly=no&summary_risk_score=0&time_zone=660&true_ip=220.233.95.244&true_ip_geo=AU&event_type=payment&request_result=success&review_status=reject
'''
}
else if (requestXml.contains('THREATMETRIX_ERROR'))
{
    responseStr = '''
device_id=82bff208d2e911dc800000163e3cf324&device_result=not+found&enabled_ck=yes&enabled_fl=yes&enabled_js=yes&os=Windows+NT+5.1&proxy_ip=192.168.0.154&proxy_ip_reputation=100&screen_res=1920x1200&session_anomaly=no&summary_risk_score=0&time_zone=660&true_ip=220.233.95.244&true_ip_geo=AU&event_type=payment&request_result=fail_invalid_parameter&review_status=error
'''
}
else if (requestXml.contains('account_name=Threatreject'))
{
    responseStr = '''
device_id=82bff208d2e911dc800000163e3cf324&device_result=not+found&enabled_ck=yes&enabled_fl=yes&enabled_js=yes&os=Windows+NT+5.1&proxy_ip=192.168.0.154&proxy_ip_reputation=100&screen_res=1920x1200&session_anomaly=no&summary_risk_score=0&time_zone=660&true_ip=220.233.95.244&true_ip_geo=AU&event_type=payment&request_result=success&review_status=reject
'''
}
else
{
    responseStr = '''
device_id=82bff208d2e911dc800000163e3cf324&device_result=not+found&enabled_ck=yes&enabled_fl=yes&enabled_js=yes&os=Windows+NT+5.1&proxy_ip=192.168.0.154&proxy_ip_reputation=100&screen_res=1920x1200&session_anomaly=no&summary_risk_score=0&time_zone=660&true_ip=220.233.95.244&true_ip_geo=AU&event_type=payment&request_result=success&review_status=pass
'''
}
return responseStr
