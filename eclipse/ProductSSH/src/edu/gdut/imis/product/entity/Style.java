package edu.gdut.imis.product.entity;

public enum Style {
	Clothes("服装"),
    Food("食物"),
    Book("图书"),
	Cosmetics("化妆品");
	
	private String value;
    
    private Style(String value){
        this.value=value;
    }
	 public void setValue(String value) {
			this.value = value;
		}
    public String getValue(){
        return value;
    }
//    public static void main(String []args) {
//    	for (Style testEnum : Style.values()) {
//                System.out.println(testEnum.getValue());
//        }
//    }
}
