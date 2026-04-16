package cts.student.examen.g1092.builder;

public class ProductionItem implements IProductionItem{
    private String modelName;
    private String serialCode;
    private String materialType;

    private String batchLabel;
    private String packagingType;
    private boolean specialFinish;
    private boolean qualityCheck;
    private String assemblyInstructions;
    private String deliveryPriority;

    private ProductionItem(ProductionItemBuilder builder) {
        this.modelName = builder.modelName;
        this.serialCode = builder.serialCode;
        this.materialType = builder.materialType;
        this.batchLabel = builder.batchLabel;
        this.packagingType = builder.packagingType;
        this.specialFinish = builder.specialFinish;
        this.qualityCheck = builder.qualityCheck;
        this.assemblyInstructions = builder.assemblyInstructions;
        this.deliveryPriority = builder.deliveryPriority;
    }

    public static class ProductionItemBuilder{
        private String modelName;
        private String serialCode;
        private String materialType;

        private String batchLabel;
        private String packagingType;
        private boolean specialFinish;
        private boolean qualityCheck;
        private String assemblyInstructions;
        private String deliveryPriority;

        public ProductionItemBuilder(String modelName, String serialCode, String materialType) {
            this.modelName = modelName;
            this.serialCode = serialCode;
            this.materialType = materialType;
        }

        public ProductionItemBuilder setBatchLabel(String batchLabel) {
            this.batchLabel = batchLabel;
            return this;
        }

        public ProductionItemBuilder setPackagingType(String packagingType) {
            this.packagingType = packagingType;
            return this;
        }

        public ProductionItemBuilder setSpecialFinish(boolean specialFinish) {
            this.specialFinish = specialFinish;
            return this;
        }

        public ProductionItemBuilder setQualityCheck(boolean qualityCheck) {
            this.qualityCheck = qualityCheck;
            return this;
        }

        public ProductionItemBuilder setAssemblyInstructions(String assemblyInstructions) {
            this.assemblyInstructions = assemblyInstructions;
            return this;
        }

        public ProductionItemBuilder setDeliveryPriority(String deliveryPriority) {
            this.deliveryPriority = deliveryPriority;
            return this;
        }
        public ProductionItem build(){
            return new ProductionItem(this);
        }
    }

    @Override public String getModelName() { return modelName; }
    @Override public String getSerialCode() { return serialCode; }
    @Override public String getMaterialType() { return materialType; }
    @Override public String getBatchLabel() { return batchLabel; }
    @Override public String getPackagingType() { return packagingType; }

    @Override
    public void displayInfo() {
        System.out.println( "ProductionItem{" +
                "modelName='" + modelName + '\'' +
                ", serialCode='" + serialCode + '\'' +
                ", materialType='" + materialType + '\'' +
                ", batchLabel='" + batchLabel + '\'' +
                ", packagingType='" + packagingType + '\'' +
                ", specialFinish=" + specialFinish +
                ", qualityCheck=" + qualityCheck +
                ", assemblyInstructions='" + assemblyInstructions + '\'' +
                ", deliveryPriority='" + deliveryPriority + '\'' +
                '}');
    }
}
