package com.commons.utils.handlers;

import com.commons.utils.constants.Messages;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.errors.EntityFindByIdWarning;
import com.commons.utils.errors.EntityUserNotFoundWarning;
import com.commons.utils.utils.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class HandlerExceptionCommonController extends ResponseEntityExceptionHandler {

   /* » Handler: Internal Exceptión... */
   @Override
   protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
         HttpStatus status, WebRequest request) {
      return new ResponseEntity<>(getResponseException(status, ex), status);
   }

   /* » Handler: Custom Exceptión... */
   @ExceptionHandler({ DataAccessEmptyWarning.class })
   @ResponseStatus(HttpStatus.OK)
   protected Response handlerNotFound(DataAccessEmptyWarning e) {
      String idLog = LogAndResponseHandler.getIdLog();
      String msjResponse = e.getMessage();
      return LogAndResponseHandler.getLogAndResponse(idLog, msjResponse, msjResponse, null);
   }

   @ExceptionHandler({ EntityFindByIdWarning.class, EntityUserNotFoundWarning.class })
   @ResponseStatus(HttpStatus.OK)
   public Response handleDataAccessError(Exception e) {
      String idLog = LogAndResponseHandler.getIdLog();
      String msjResponse = e.getMessage();
      return LogAndResponseHandler.getLogAndResponse(idLog, msjResponse, msjResponse, null);
   }

   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.OK)
   public Response handleDataAccessException(Exception e) {
      String idLog = LogAndResponseHandler.getIdLog();
      String msjResponse = Messages.GET_MESSAGGE_ERROR_DATA_ACCESS(idLog);
      return LogAndResponseHandler.getLogAndResponse(idLog, msjResponse, e.getMessage(), e.toString());
   }

   // #region Métodos privados
   private Response getResponseException(HttpStatus status, Exception ex) {
      String idLog = LogAndResponseHandler.getIdLog();
      String msjResponse = Messages.GET_MESSAGGE_ERROR_DATA_ACCESS(idLog);
      return LogAndResponseHandler.getLogAndResponse(idLog, msjResponse, ex.getMessage(), status.getReasonPhrase());
   }
   // #endregion

}