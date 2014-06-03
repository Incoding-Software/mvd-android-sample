package com.example.mvd.app;

public enum Question_OfType {
     
     CheckBox(0) ,    
     
     TextBox(1) ;    
    

    private final int value;

    private Question_OfType(final int value) {
        this.value = value;
    }

	public static Question_OfType valueOf(int value) {
       Question_OfType[] valueEnums = Question_OfType.values();
       for (Question_OfType valueEnum : valueEnums) {
           if (valueEnum.value == value) {
               return valueEnum;
           }
       }
       throw new IllegalArgumentException();
    }
}
