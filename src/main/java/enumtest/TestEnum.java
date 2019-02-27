package enumtest;

/**
 * <p>
 * History: 
 *
 * Date                     Author         Version     Description
 * ---------------------------------------------------------------------------------
 * 2019年2月18日 下午4:28:21          Administrator        2.1         To create
 * </p>
 * 2019年2月18日 下午4:28:21          Administrator        2.1         modify parameters
 *
 * @since 
 * @see     
 */
public enum TestEnum {
    ONE(1), TOW(2);

    private int value;

    /**
     * @param value
     */
    private TestEnum(int value) {
        this.value = value;
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }

}
