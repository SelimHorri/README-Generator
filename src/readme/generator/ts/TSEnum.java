package readme.generator.ts;

import readme.generator.Pair;

import java.util.*;

public class TSEnum extends TSBaseComponent {

    private List<EnumVar> variableList;
    private String eName;

    public TSEnum(String eName){
        this.variableList = new ArrayList<>();
        this.eName = eName;
    }

    public TSEnum(){
        this.variableList = new ArrayList<>();
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public void addVariable(EnumVar enumVar){
        this.variableList.add(enumVar);
    }

    public List<EnumVar> getVariableList() {
        return variableList;
    }

    public String geteName() {
        return eName;
    }

    @Override
    public String toString() {
        return "TSEnum{" +
                "variableList=" + variableList +
                ", eName='" + eName + '\'' +
                ", export='" + isExport() + '\'' +
                '}';
    }

    @Override
    public Map toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("Title", this.eName);
        List<Pair<String, String>> fieldValue = new ArrayList<>();
        for(EnumVar e : this.variableList){
            fieldValue.add(new Pair<>(e.vaName, e.vaValue));
        }
        map.put("Field-Value", fieldValue);
        return map;
    }

    public static class EnumVar{
        private String vaName, vaValue;
        public EnumVar(){}
        public EnumVar(String vaName, String vaValue){
            this.vaName = vaName; this.vaValue = vaValue;
        }
        public void setVaName(String vaName) {
            this.vaName = vaName;
        }
        public void setVaValue(String vaValue) {
            this.vaValue = vaValue;
        }

        @Override
        public String toString() {
            return "EnumVar{" +
                    "eName='" + vaName + '\'' +
                    ", eValue='" + vaValue + '\'' +
                    '}';
        }
    }
}
