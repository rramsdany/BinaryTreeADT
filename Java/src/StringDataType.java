public class StringDataType extends GenericItemType{

    private String privateValue;

    public StringDataType(){}

    public StringDataType(String privateValue){
        this.privateValue = privateValue;
    }

    public StringDataType(StringDataType sdt){
        privateValue = sdt.privateValue;
    }

    public void set(String privateValue){
        this.privateValue = privateValue;
    }

    public String get(){
        return privateValue;
    }

    @Override
    public boolean isLess(GenericItemType git) {
        return ( privateValue.compareTo(((StringDataType) git).get()) < 0 );
    }

    @Override
    public boolean isEqual(GenericItemType git) {
        return ( privateValue.compareTo(((StringDataType) git).get()) == 0 );
    }

    @Override
    public boolean isGreater(GenericItemType git) {
        return ( privateValue.compareTo(((StringDataType) git).get()) > 0 );
    }
}
