package com.example.demo414;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.net.URI;

@Path("/hello-world")
public class HelloResource {
    @GET
    @Produces("text/plain")
   // @Produces(MediaType.SERVER_SENT_EVENTS)
    public String hello() {
        return "Hello, World!";
    }

    private static final String TEXTFILE_PATH = "project.log";
    private static final String IMAGEFILE_PATH = "CLIerrorMsg.jpg";
    private static final String PDFFILE_PATH = "gaenselieselstrasse_projektinfo.pdf";
    private static final String EXCELFILE_PATH = "EXCEL_Example.XLSX";


    @GET
    @Path("/redirect") //   /ExampleResource/text
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getRedirect() {

        Response.ResponseBuilder response = Response.temporaryRedirect(URI.create("http://localhost:8080/demo414_war/api/hello-world/redirect2"));
        Response.ResponseBuilder response2 = Response.temporaryRedirect(URI.create("https://google.com/"));
//
//        Response.temporaryRedirect(URI)
//
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream(TEXTFILE_PATH);
//        Response.ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
//        response.header("Content-Disposition", "attachment; filename=\"" + TEXTFILE_PATH + "\"");
        return response.build();

    }

 @GET
    @Path("/redirect2") //   /ExampleResource/text
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getRedirect2() {

        Response.ResponseBuilder response = Response.temporaryRedirect(URI.create("http://localhost:8080/demo414_war/api/hello-world/redirect3"));
     // Response.ResponseBuilder response2 = Response.temporaryRedirect(URI.create("https://google.com/"));
//
//        Response.temporaryRedirect(URI)
//
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream(TEXTFILE_PATH);
//        Response.ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
//        response.header("Content-Disposition", "attachment; filename=\"" + TEXTFILE_PATH + "\"");
        return response.build();

    }

    @GET
    @Path("/redirect3") //   /ExampleResource/text
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getRedirect3() {

        Response.ResponseBuilder response = Response.temporaryRedirect(URI.create("http://localhost:8080/demo414_war/api/hello-world/text"));
       // Response.ResponseBuilder response2 = Response.temporaryRedirect(URI.create("https://google.com/"));
//
//        Response.temporaryRedirect(URI)
//
//        InputStream in = this.getClass().getClassLoader().getResourceAsStream(TEXTFILE_PATH);
//        Response.ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
//        response.header("Content-Disposition", "attachment; filename=\"" + TEXTFILE_PATH + "\"");
        return response.build();

    }

    @GET
    @Path("/text") //   /ExampleResource/text
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getTextFile() {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(TEXTFILE_PATH);
        Response.ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
        response.header("Content-Disposition", "attachment; filename=\"" + TEXTFILE_PATH + "\"");
        return response.build();

    }

    @GET
    @Path("/image")  //   /ExampleResource/image
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getImageFile() {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(IMAGEFILE_PATH);

        Response.ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
        response.header("Content-Disposition",
                "attachment; filename=\"" + IMAGEFILE_PATH + "\"");
        return response.build();

    }


    @GET
    @Path("/pdf") //  /ExampleResource/pdf
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getPDFFile() {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(PDFFILE_PATH);

        Response.ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
        response.header("Content-Disposition",
                "attachment; filename=\"" + PDFFILE_PATH + "\"");
        return response.build();

    }


    @GET
    @Path("/excel") //   /ExampleResource/excel
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getExcelFile() {

        InputStream in = this.getClass().getClassLoader().getResourceAsStream(EXCELFILE_PATH);

        Response.ResponseBuilder response = Response.ok(in, MediaType.APPLICATION_OCTET_STREAM);
        response.header("Content-Disposition",
                "attachment; filename=\"" + EXCELFILE_PATH + "\"");
        return response.build();

    }


}
