package com.commons.utils.constants;

import com.commons.utils.utils.LogAndResponse;

public class Messages {
   /*-> SUCCESS: */
   public static final String MESSAGE_SUCCESS_NEW_ID = "¡El código %d, ha sido generado con exito!";
   public static final String MESSAGE_SUCCESS_LIST_ENTITY = "¡La tabla fué listada con exito!";
   public static final String MESSAGE_SUCCESS_CREATE = "¡Registró exitoso!";
   public static final String MESSAGE_SUCCESS_UPDATE = "¡La table fué actualizada con exito!";
   public static final String MESSAGE_SUCCESS_DOWNLOAD = "¡El anexo, se descargo exitosamente!";
   public static final String MESSAGE_SUCCESS_AUTH = "!Acceso permitido¡";
   public static final String MESSAGE_SUCCES_SEARCH_RESULT = "¡Se encontraron resultados, para : %s!";
   public static final String MESSAGE_SUCCES_CREATE_USER = "¡El usuario %s, fué creado con exito!";

   /*-> WARNING: */
   public final static String MESSAGGE_WARNING_EMPTY = "¡No hay registros para mostrar!";
   public final static String MESSAGE_WARNING_ENTITY_FIND_BY_ID = "¡El código %s, no existe en la tabla!";
   public final static String MESSAGE_WARNING_ENTITY_USER = "¡Usuario o clave incorrecta!";

   /*-> ERROR: */
   public final static String MESSAGGE_ERROR_DATA_ACCESS = "¡Ocurrió un error, contacte a sitemas y proporcione este código %s!";

   /*-> -----------------------------METHOD'S--------------------------- */
   /*-> SUCCESS: */
   public static String GET_MESSAGE_SUCCESS_CREATE() {
      return MESSAGE_SUCCESS_CREATE;
   }

   public static String GET_MESSAGE_SUCCESS_UPDATE() {
      return MESSAGE_SUCCESS_UPDATE;
   }

   public static String GET_MESSAGE_SUCCES_SEARCH_RESULT(String value) {
      return String.format(MESSAGE_SUCCES_SEARCH_RESULT, value);
   }

   public static String GET_MESSAGE_SUCCES_CREATE_USER(String newUser) {
      return String.format(MESSAGE_SUCCES_CREATE_USER, newUser);
   }

   public static String GET_MESSAGE_SUCCESS_NEW_ID(Long newId) {
      return String.format(MESSAGE_SUCCESS_NEW_ID, newId);
   }

   public static String GET_MESSAGE_SUCCESS_LIST_ENTITY() {
      return MESSAGE_SUCCESS_LIST_ENTITY;
   }

   /*-> WARNING */
   public static String GET_MESSAGE_WARNING_ENTITY_FIND_BY_ID(String id) {
      return String.format(MESSAGE_WARNING_ENTITY_FIND_BY_ID, id);
   }

   public static String GET_MESSAGGE_WARNING_EMPTY() {
      return MESSAGGE_WARNING_EMPTY;
   }

   /*-> ERROR */
   public static String GET_MESSAGGE_ERROR_DATA_ACCESS() {
      return String.format(MESSAGGE_ERROR_DATA_ACCESS, LogAndResponse.getIdLog());
   }

}
