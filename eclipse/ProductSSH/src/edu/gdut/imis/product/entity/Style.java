package edu.gdut.imis.product.entity;

public enum Style {
	Clothes("��װ"),
    Food("ʳ��"),
    Book("ͼ��"),
	Cosmetics("��ױƷ");
	
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
