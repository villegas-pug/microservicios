package com.commons.utils.errors;

import com.commons.utils.constants.*;

public class EntityUserNotFoundWarning extends RuntimeException {

   /**
    *
    */
   private static final long serialVersionUID = 1L;

   public EntityUserNotFoundWarning() {
      super(Messages.MESSAGE_WARNING_ENTITY_USER);
      System.setProperty("levelLog", LevelLog.WARNING);
   }

}
