package cts.nume.prenume.gNrGrupa.builder;

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

    public ProductionItem(ProductionItemBuilder builder){
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

    public static class ProductionItemBuilder implements IBuilder{

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

        @Override
        public ProductionItem build() {
            return new ProductionItem(this);
        }
    }

    @Override
    public String getModelName() {
        return "";
    }

    @Override
    public String getSerialCode() {
        return "";
    }

    @Override
    public String getMaterialType() {
        return "";
    }

    @Override
    public String getBatchLabel() {
        return "";
    }

    @Override
    public String getPackagingType() {
        return "";
    }

    @Override
    public void displayInfo() {

    }
}
