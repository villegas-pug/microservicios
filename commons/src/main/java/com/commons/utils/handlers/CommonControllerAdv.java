package com.commons.utils.handlers;

import com.commons.utils.constants.Messages;
import com.commons.utils.errors.DataAccessEmptyWarning;
import com.commons.utils.errors.EntityFindByIdWarning;
import com.commons.utils.errors.EntityUserNotFoundWarning;
import com.commons.utils.utils.*;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CommonControllerAdv extends ResponseEntityExceptionHandler {

   // #region: Internal Exceptión
   @Override
   protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
         HttpStatus status, WebRequest request) {
      return new ResponseEntity<>(handleInternalResponseException(status, ex), status);
   }

   private Response handleInternalResponseException(HttpStatus status, Exception ex) {
      return LogAndResponse.handleLogAndResponse(Messages.GET_MESSAGGE_ERROR_DATA_ACCESS(), ex.getMessage(),
            status.getReasonPhrase());
   }
   // #endregion

   // #region : Custom Exceptión
   @ExceptionHandler({ DataAccessEmptyWarning.class })
   @ResponseStatus(HttpStatus.OK)
   public Response handlerNotFound(DataAccessEmptyWarning e) {
      String msjResponse = e.getMessage();
      return LogAndResponse.handleLogAndResponse(msjResponse, msjResponse, null);
   }

   @ExceptionHandler({ EntityFindByIdWarning.class, EntityUserNotFoundWarning.class })
   @ResponseStatus(HttpStatus.OK)
   public Response handleDataAccessError(Exception e) {
      String msjResponse = e.getMessage();
      return LogAndResponse.handleLogAndResponse(msjResponse, msjResponse, null);
   }

   @ExceptionHandler(Exception.class)
   @ResponseStatus(HttpStatus.OK)
   public Response handleDataAccessException(Exception e) {
      String msjResponse = Messages.GET_MESSAGGE_ERROR_DATA_ACCESS();
      return LogAndResponse.handleLogAndResponse(msjResponse, e.getMessage(), e.toString());
   }
   // endregion

}