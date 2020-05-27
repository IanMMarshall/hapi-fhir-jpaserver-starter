package ca.uhn.fhir.jpa.starter;

import ca.uhn.fhir.interceptor.api.Hook;
import ca.uhn.fhir.interceptor.api.Interceptor;
import ca.uhn.fhir.interceptor.api.Pointcut;
import ca.uhn.fhir.rest.api.server.RequestDetails;
import ca.uhn.fhir.rest.server.interceptor.LoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Interceptor
public class RequestTrackingInterceptor extends LoggingInterceptor {

  private final Logger ourLog = LoggerFactory.getLogger(RequestTrackingInterceptor.class);

  @Hook(Pointcut.SERVER_INCOMING_REQUEST_PRE_HANDLED)
  public void logRequests(RequestDetails theRequest) {
    ourLog.info("Request of type {} with request ID: {}", theRequest.getOperation(), theRequest.getRequestId());
  }

}
