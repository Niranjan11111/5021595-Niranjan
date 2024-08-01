public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer computer1 = new Computer.Builder("Intel i7", "16GB")
                                .setStorage("512GB SSD")
                                .setGraphicsCard("NVIDIA GTX 1660")
                                .build();
        
        Computer computer2 = new Computer.Builder("AMD Ryzen 5", "8GB")
                                .setStorage("1TB HDD")
                                .build();
        
        System.out.println(computer1);
        System.out.println(computer2);
    }
}

class Computer {
    private String cpu;
    private String ram;
    private String storage;
    private String graphicsCard;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
    }

    public static class Builder {
        private String cpu;
        private String ram;
        private String storage;
        private String graphicsCard;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + cpu + ", RAM=" + ram + ", Storage=" + storage + ", GraphicsCard=" + graphicsCard + "]";
    }
}
