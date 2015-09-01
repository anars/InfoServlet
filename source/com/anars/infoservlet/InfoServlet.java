/**
 * InfoServlet - Servlet that outputs information about request, server and operating system.
 * Copyright (c) 2014-2015 Anar Software LLC. < http://anars.com >
 * 
 * This program is free software: you can redistribute it and/or modify it under 
 * the terms of the GNU General Public License as published by the Free Software 
 * Foundation, either version 3 of the License, or (at your option) any later 
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with 
 * this program.  If not, see < http://www.gnu.org/licenses/ >
 * 
 */
package com.anars.infoservlet;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * InfoServlet class.
 *
 * @author Kay Anar
 * @version 1.0
 *
 */
public class InfoServlet
  extends HttpServlet
{
  public void init(ServletConfig config)
    throws ServletException
  {
    super.init(config);
  }

  public void service(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    int year = Calendar.getInstance().get(Calendar.YEAR);
    HttpSession session = request.getSession(true);
    StringBuffer outBuffer = new StringBuffer();
    outBuffer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
    outBuffer.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
    outBuffer.append(" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">\n");
    outBuffer.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">\n");
    outBuffer.append(" <head>\n");
    outBuffer.append("  <title>InfoServlet : Server, Servlet, Request Information</title>\n");
    outBuffer.append("  <meta http-equiv=\"content-type\" ");
    outBuffer.append("content=\"application/xhtml+xml; charset=utf-8\"/>\n");
    outBuffer.append("  <meta http-equiv=\"cache-control\" content=\"no-cache\"/>\n");
    outBuffer.append("  <meta http-equiv=\"content-language\" content=\"en-us\"/>\n");
    outBuffer.append("  <meta http-equiv=\"expires\" content=\"0\"/>\n");
    outBuffer.append("  <meta http-equiv=\"pragma\" content=\"no-cache\"/>\n");
    outBuffer.append("  <meta name=\"robots\" content=\"none\"/>\n");
    outBuffer.append("  <meta name=\"googlebot\" content=\"noarchive\"/>\n");
    outBuffer.append("  <meta name=\"author\" content=\"Anar Software LLC\"/>\n");
    outBuffer.append("  <meta name=\"copyright\" content=\"(c) ");
    outBuffer.append(year);
    outBuffer.append(" Anar Software LLC\"/>\n");
    outBuffer.append("  <meta name=\"description\" content=\"Displays information ");
    outBuffer.append("about the current state of Java Servlet, Incoming HTTP request, ");
    outBuffer.append("application server and operating system.\"/>\n");
    outBuffer.append("  <meta name=\"keywords\" content=\"java, servlet, request, ");
    outBuffer.append("session, server, web, cookie, http, http request\"/>\n");
    outBuffer.append("  <style type=\"text/css\">\n");
    outBuffer.append("   body\n");
    outBuffer.append("   {\n");
    outBuffer.append("    font: normal 14px Arial, Helvetica, sans-serif;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   a\n");
    outBuffer.append("   {\n");
    outBuffer.append("    color: #005075;\n");
    outBuffer.append("    text-decoration: none;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   a:hover\n");
    outBuffer.append("   {\n");
    outBuffer.append("    text-decoration: underline;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   table\n");
    outBuffer.append("   {\n");
    outBuffer.append("    border-width: 1px 1px 1px 1px;\n");
    outBuffer.append("    border-spacing: 2px;\n");
    outBuffer.append("    border-style: none none none none;\n");
    outBuffer.append("    border-color: black black black black;\n");
    outBuffer.append("    border-collapse: separate;\n");
    outBuffer.append("    background-color: white;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   table tr\n");
    outBuffer.append("   {\n");
    outBuffer.append("    border-width: 1px 1px 1px 1px;\n");
    outBuffer.append("    padding: 4px 4px 4px 4px;\n");
    outBuffer.append("    border-style: solid solid solid solid;\n");
    outBuffer.append("    border-color: black black black black;\n");
    outBuffer.append("    -moz-border-radius: 3px 3px 3px 3px;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   table tr.oddRow\n");
    outBuffer.append("   {\n");
    outBuffer.append("    background-color: #eff2ff;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   table tr.evenRow\n");
    outBuffer.append("   {\n");
    outBuffer.append("    background-color: #ffffff;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   table tr.headerRow\n");
    outBuffer.append("   {\n");
    outBuffer.append("    font-size:200%;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   table td\n");
    outBuffer.append("   {\n");
    outBuffer.append("    border-width: 1px 1px 1px 1px;\n");
    outBuffer.append("    padding: 4px 4px 4px 4px;\n");
    outBuffer.append("    border-style: solid solid solid solid;\n");
    outBuffer.append("    border-color: black black black black;\n");
    outBuffer.append("    -moz-border-radius: 3px 3px 3px 3px;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   #copyright\n");
    outBuffer.append("   {\n");
    outBuffer.append("    font-size: x-small;\n");
    outBuffer.append("    text-align:center;\n");
    outBuffer.append("   }\n");
    outBuffer.append("   .command\n");
    outBuffer.append("   {\n");
    outBuffer.append("    font-size: x-small;\n");
    outBuffer.append("   }\n");
    outBuffer.append("  </style>\n");
    outBuffer.append(" </head>\n");
    outBuffer.append(" <body>\n");
    outBuffer.append("  <h1>InfoServlet : Server, Servlet, Request Information</h1>\n");
    outBuffer.append("  <table id=\"X\" class=\"X\">\n");
    outBuffer.append("   <tbody>\n");
    int rowNumber = 0;
    Enumeration enumeration = sortKeys(request.getHeaderNames());
    if (enumeration.hasMoreElements())
    {
      outBuffer.append("    <tr class=\"headerRow\">\n");
      outBuffer.append("     <td colspan=\"2\">HTTP Headers</td>\n");
      outBuffer.append("    </tr>\n");
    }
    while (enumeration.hasMoreElements())
    {
      String name = (String) enumeration.nextElement();
      String value = request.getHeader(name);
      outBuffer.append("    <tr class=\"");
      outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
      outBuffer.append("Row\">\n");
      outBuffer.append("     <td>");
      outBuffer.append(htmlEncode(name));
      outBuffer.append("<br/><span class=\"command\">");
      outBuffer.append(htmlEncode("request.getHeader(\""));
      outBuffer.append(htmlEncode(name));
      outBuffer.append(htmlEncode("\");"));
      outBuffer.append("</span>");
      outBuffer.append("</td>\n");
      outBuffer.append("     <td>");
      outBuffer.append(htmlEncode(value));
      outBuffer.append("</td>\n");
      outBuffer.append("    </tr>\n");
    }
    enumeration = null;
    outBuffer.append("    <tr class=\"headerRow\">\n");
    outBuffer.append("     <td colspan=\"2\">Request</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>AuthType");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getAuthType();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getAuthType()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>CharacterEncoding");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getCharacterEncoding();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getCharacterEncoding()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ContentLength");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getContentLength();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(request.getContentLength());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ContentType");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getContentType();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getContentType()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ContextPath");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getContextPath();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getContextPath()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>LocalAddr");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getLocalAddr();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getLocalAddr()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>LocalName");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getLocalName();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getLocalName()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>LocalPort");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getLocalPort();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(request.getLocalPort());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>Locale");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getLocale();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getLocale().toString()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>Locales");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getLocales();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    boolean first = true;
    enumeration = request.getLocales();
    while (enumeration.hasMoreElements())
    {
      outBuffer.append((!first ? ", " : ""));
      outBuffer.append(htmlEncode(enumeration.nextElement().toString()));
      first = false;
    }
    enumeration = null;
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>Method");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getMethod();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getMethod()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>PathInfo");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getPathInfo();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getPathInfo()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>PathTranslated");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getPathTranslated();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getPathTranslated()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>Protocol");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getProtocol();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getProtocol()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>QueryString");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getQueryString();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getQueryString()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>RemoteAddr");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getRemoteAddr();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getRemoteAddr()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>RemoteHost");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getRemoteHost();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getRemoteHost()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>RemotePort");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getRemotePort();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(request.getRemotePort());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>RemoteUser");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getRemoteUser();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getRemoteUser()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>RequestURI");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getRequestURI();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getRequestURI()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>RequestURL");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getRequestURL();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getRequestURL().toString()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>RequestedSessionId");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getRequestedSessionId();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getRequestedSessionId()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>Scheme");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getScheme();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getScheme()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ServerName");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getServerName();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getServerName()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ServerPort");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getServerPort();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(request.getServerPort());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ServletPath");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("request.getServletPath();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(request.getServletPath()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"headerRow\">\n");
    outBuffer.append("     <td colspan=\"2\">HTTP Session</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>CreationTime");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getCreationTime();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(session.getCreationTime());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>CreationTime as Date");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("new Date(session.getCreationTime());"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode((new Date(session.getCreationTime()).toString())));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>Id");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getId();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(session.getId()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>LastAccessedTime");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getLastAccessedTime();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(session.getLastAccessedTime());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>LastAccessedTime as Date");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("new Date(session.getLastAccessedTime());"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode((new Date(session.getLastAccessedTime()).toString())));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>MaxInactiveInterval");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getMaxInactiveInterval();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(session.getMaxInactiveInterval());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"headerRow\">\n");
    outBuffer.append("     <td colspan=\"2\">Servlet Context</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ContextPath");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getServletContext().getContextPath();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(session.getServletContext().getContextPath()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>MajorVersion");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getServletContext().getMajorVersion();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(session.getServletContext().getMajorVersion());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>MinorVersion");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getServletContext().getMinorVersion();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(session.getServletContext().getMinorVersion());
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    outBuffer.append("    <tr class=\"");
    outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
    outBuffer.append("Row\">\n");
    outBuffer.append("     <td>ServerInfo");
    outBuffer.append("<br/><span class=\"command\">");
    outBuffer.append(htmlEncode("session.getServletContext().getServerInfo();"));
    outBuffer.append("</span></td>\n");
    outBuffer.append("     <td>");
    outBuffer.append(htmlEncode(session.getServletContext().getServerInfo()));
    outBuffer.append("</td>\n");
    outBuffer.append("    </tr>\n");
    enumeration = sortKeys(request.getParameterNames());
    if (enumeration.hasMoreElements())
    {
      outBuffer.append("    <tr class=\"headerRow\">\n");
      outBuffer.append("     <td colspan=\"2\">Parameters</td>\n");
      outBuffer.append("    </tr>\n");
    }
    while (enumeration.hasMoreElements())
    {
      String name = (String) enumeration.nextElement();
      String value = request.getParameter(name);
      outBuffer.append("    <tr class=\"");
      outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
      outBuffer.append("Row\">\n");
      outBuffer.append("     <td>");
      outBuffer.append(htmlEncode(name));
      outBuffer.append("<br/><span class=\"command\">");
      outBuffer.append(htmlEncode("request.getParameter(\""));
      outBuffer.append(htmlEncode(name));
      outBuffer.append("\");</span></td>\n");
      outBuffer.append("     <td>");
      outBuffer.append(htmlEncode(value));
      outBuffer.append("</td>\n");
      outBuffer.append("    </tr>\n");
    }
    enumeration = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null)
    {
      outBuffer.append("    <tr class=\"headerRow\">\n");
      outBuffer.append("     <td colspan=\"2\">Cookies</td>\n");
      outBuffer.append("    </tr>\n");
      for (int index = 0; cookies != null && index < cookies.length; index++)
      {
        outBuffer.append("    <tr class=\"");
        outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
        outBuffer.append("Row\">\n");
        outBuffer.append("     <td>");
        outBuffer.append(htmlEncode(cookies[index].getName()));
        outBuffer.append("<br/><span class=\"command\">");
        outBuffer.append(htmlEncode("request.getCookies()["));
        outBuffer.append(index);
        outBuffer.append("]);</span></td>\n");
        outBuffer.append("     <td>");
        outBuffer.append(htmlEncode(cookies[index].getValue()));
        outBuffer.append("</td>\n");
        outBuffer.append("    </tr>\n");
      }
    }
    enumeration = sortKeys(System.getProperties().keys());
    if (enumeration.hasMoreElements())
    {
      outBuffer.append("    <tr class=\"headerRow\">\n");
      outBuffer.append("     <td colspan=\"2\">System Properties</td>\n");
      outBuffer.append("    </tr>\n");
    }
    while (enumeration.hasMoreElements())
    {
      String name = (String) enumeration.nextElement();
      String value = System.getProperty(name);
      outBuffer.append("    <tr class=\"");
      outBuffer.append(++rowNumber % 2 == 0 ? "odd" : "even");
      outBuffer.append("Row\">\n");
      outBuffer.append("     <td>");
      outBuffer.append(htmlEncode(name));
      outBuffer.append("<br/><span class=\"command\">");
      outBuffer.append(htmlEncode("System.getProperty(\""));
      outBuffer.append(htmlEncode(name));
      outBuffer.append(htmlEncode("\");"));
      outBuffer.append("</span>");
      outBuffer.append("</td>\n");
      outBuffer.append("     <td>");
      outBuffer.append(htmlEncode(value));
      outBuffer.append("</td>\n");
      outBuffer.append("    </tr>\n");
    }
    outBuffer.append("   </tbody>\n");
    outBuffer.append("  </table>\n");
    outBuffer.append(" <p id=\"copyright\">Copyright &copy; 2014-");
    outBuffer.append(year);
    outBuffer.append(" <a href=\"http://anars.com\">Anar Software LLC</a>.");
    outBuffer.append("This software is licensed under the ");
    outBuffer.append("<a href=\"http://www.gnu.org/licenses/gpl.html\">");
    outBuffer.append("GNU General Public License</a> version 3.0 or later. ");
    outBuffer.append("This program comes with ABSOLUTELY NO WARRANTY.</p>");
    outBuffer.append(" </body>\n");
    outBuffer.append("</html>\n");
    response.setContentType("application/xhtml+xml; charset=utf-8");
    PrintWriter printWriter = response.getWriter();
    printWriter.print(outBuffer.toString());
    printWriter.close();
  }
  
  private synchronized Enumeration sortKeys(Enumeration keysEnum)
  {
    Vector keyList = new Vector();
    while (keysEnum.hasMoreElements())
      keyList.add(keysEnum.nextElement());
    Collections.sort(keyList);
    return keyList.elements();
  }

  private String htmlEncode(String string)
  {
    if (string == null)
      return (null);
    StringBuffer stringBuffer = new StringBuffer();
    for (int offset = 0; offset < string.length(); offset++)
    {
      char character = string.charAt(offset);
      if ((character >= 'a' && character <= 'z') || (character >= 'A' && character <= 'Z') || (character >= '0' && character <= '9') || character == '\n' || character == '\r' || character == ' ')
      {
        stringBuffer.append(character);
      }
      else if (Character.isHighSurrogate(character))
      {
        int codePoint;
        if (offset + 1 < string.length() && Character.isSurrogatePair(character, string.charAt(offset + 1)) && Character.isDefined(codePoint = (Character.toCodePoint(character, string.charAt(offset + 1)))))
          stringBuffer.append("&#").append(codePoint).append(";");
        offset++;
      }
      else if (Character.isLowSurrogate(character))
      {
        offset++;
      }
      else if (Character.isDefined(character) && !Character.isISOControl(character))
      {
        stringBuffer.append("&#").append((int) character).append(";");
      }
    }
    return (stringBuffer.toString());
  }
}
