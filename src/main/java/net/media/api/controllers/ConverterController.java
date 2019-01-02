package net.media.api.controllers;


import com.google.inject.Inject;
import net.media.mapper.RequestConverter;
import net.media.openrtb24.request.BidRequest;
import net.media.openrtb3.Request;
import net.media.util.JacksonObjectMapper;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("convert")
public class ConverterController {

  @Inject
  private RequestConverter requestConverter;


  @POST
  @Path("/2xTo3/request")
  public Response convert2xTo3Request(BidRequest bidRequest) {
    try {
      return Response.ok(JacksonObjectMapper.getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requestConverter.mapRequestToBidRequest(bidRequest))).build();
    } catch (Exception e) {
      return Response.serverError().entity(e).build();
    }
  }

  @POST
  @Path("/3To2x/request")
  public Response convert3To2xRequest(Request request) {
    try {
      return Response.ok(JacksonObjectMapper.getMapper().writerWithDefaultPrettyPrinter().writeValueAsString(requestConverter.mapRtb3RequestToRtb24BidRequest(request))).build();
    } catch (Exception e) {
      return Response.serverError().entity(e).build();
    }
  }
}
