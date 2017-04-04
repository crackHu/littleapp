package ml.littleapp.security.model;
public enum UserStatus {  
  
    /** 无效*/  
    DISABLED(0),  
    /** 有效 */  
    AVAILABLE(1);  
      
    private int status;  
      
    UserStatus(int status){  
        this.status = status;  
    }  
  
    public int getStatus() {  
        return status;  
    }  
      
} 