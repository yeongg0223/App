package com.example.creative.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class BusApiUtil {
	public static final String SERVICE_KEY = "JK6riPEgP12xVJJmnoeQW6MtHejP9PQEfycBV/Lmp4Ip5gFPl4xIYiXhP37c1PR4CpdIaEG1DOOyaXm4mw7VQQ==";
	
	public static List<Map<String, Object>> getArrInfoByRouteAllList(String busRouteId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRouteAll"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선ID*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getArrInfoByRouteList(String stId, String busRouteId, String ord) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/arrive/getArrInfoByRoute"); 				/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("stId","UTF-8") 		+ "=" + URLEncoder.encode(stId, "UTF-8")); 			/*정류소 고유 ID*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/
            urlBuilder.append("&" + URLEncoder.encode("ord","UTF-8") 		+ "=" + URLEncoder.encode(ord, "UTF-8")); 			/*정류소 순번*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getLowArrInfoByStIdList(String stId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/arrive/getLowArrInfoByStId"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("stId","UTF-8") 		+ "=" + URLEncoder.encode(stId, "UTF-8")); 			/*노선ID*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getLowArrInfoByRouteList(String stId, String busRouteId, String ord) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/arrive/getLowArrInfoByRoute"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("stId","UTF-8") 		+ "=" + URLEncoder.encode(stId, "UTF-8")); 			/*정류소 고유 ID*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/
            urlBuilder.append("&" + URLEncoder.encode("ord","UTF-8") 		+ "=" + URLEncoder.encode(ord, "UTF-8")); 			/*정류소 순번*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getBusPosByRouteStList(String busRouteId, String startOrd, String endOrd) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/buspos/getBusPosByRouteSt"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/
            urlBuilder.append("&" + URLEncoder.encode("startOrd","UTF-8") 	+ "=" + URLEncoder.encode(startOrd, "UTF-8")); 		/*시작 정류소 순번*/
            urlBuilder.append("&" + URLEncoder.encode("endOrd","UTF-8") 	+ "=" + URLEncoder.encode(endOrd, "UTF-8")); 		/*종료 정류소 순번*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getBusPosByRtidList(String busRouteId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/buspos/getBusPosByRtid"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getBusPosByVehIdItem(String vehId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/buspos/getBusPosByVehId"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("vehId","UTF-8") 		+ "=" + URLEncoder.encode(vehId, "UTF-8")); 		/*vehId*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getLowBusPosByRtidList(String busRouteId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/buspos/getLowBusPosByRtid"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getLowBusPosByRouteStList(String busRouteId, String startOrd, String endOrd) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/buspos/getLowBusPosByRouteSt"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/
            urlBuilder.append("&" + URLEncoder.encode("startOrd","UTF-8") 	+ "=" + URLEncoder.encode(startOrd, "UTF-8")); 		/*시작 정류소 순번*/
            urlBuilder.append("&" + URLEncoder.encode("endOrd","UTF-8") 	+ "=" + URLEncoder.encode(endOrd, "UTF-8")); 		/*종료 정류소 순번*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getStaionsByRouteList(String busRouteId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/busRouteInfo/getStaionByRoute"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}

	public static List<Map<String, Object>> getRouteInfoItem(String busRouteId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/busRouteInfo/getRouteInfo"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}

	public static List<Map<String, Object>> getRoutePathList(String busRouteId) {
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/busRouteInfo/getRoutePath"); 			/*URL*/

            urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8")); 	/*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("busRouteId","UTF-8") + "=" + URLEncoder.encode(busRouteId, "UTF-8")); 	/*노선 ID*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}

	public static List<Map<String, Object>> getBusRouteList(String strSrch)  {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        try {
            StringBuilder urlBuilder = new StringBuilder("http://ws.bus.go.kr/api/rest/busRouteInfo/getBusRouteList");            /*URL*/
            urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=" + URLEncoder.encode(SERVICE_KEY, "UTF-8"));    /*Service Key*/
            urlBuilder.append("&" + URLEncoder.encode("strSrch", "UTF-8") + "=" + URLEncoder.encode(strSrch, "UTF-8"));        /*검색할 노선번호*/

            resultList = getUrlConnectionResult(urlBuilder.toString());

        } catch (Exception e) {
            e.getStackTrace();
        }
        return resultList;
	}
	
	public static List<Map<String, Object>> getUrlConnectionResult(String strUrl) throws Exception {
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        URL url = new URL(strUrl);
        System.out.println(url);
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        InputSource is = new InputSource(new StringReader(sb.toString()));
        is.setEncoding("UTF-8");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(is);

        NodeList nodeList = doc.getElementsByTagName("itemList");
        if(nodeList == null || nodeList.getLength() == 0) return resultList;

        for(int i = 0; i < nodeList.getLength(); i++) {
            Map<String, Object> tmpMap = new HashMap<>();
            NodeList childList = nodeList.item(i).getChildNodes();
            for(int j = 0; j < childList.getLength(); j++) {
                tmpMap.put(childList.item(j).getNodeName(), childList.item(j).getTextContent());
            }
            resultList.add(tmpMap);
        }
        
		return resultList;
	}

    public static List<Map<String, Object>> getUrlConnectionResult2(String strUrl) throws Exception {
        System.out.println(strUrl);
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(strUrl);
        System.out.println(doc.toString());

        NodeList nodeList = doc.getElementsByTagName("itemList");
        if(nodeList == null || nodeList.getLength() == 0) return resultList;

        for(int i = 0; i < nodeList.getLength(); i++) {
            Map<String, Object> tmpMap = new HashMap<>();
            NodeList childList = nodeList.item(i).getChildNodes();
            for(int j = 0; j < childList.getLength(); j++) {
                tmpMap.put(childList.item(j).getNodeName(), childList.item(j).getTextContent());
            }
            resultList.add(tmpMap);
        }

        return resultList;
    }
}
