public abstract class maze implements board{


        private int width;
        private int length;

        public maze( int width, int length) {
            this.width = width;
            this.length = length;
        }

        // accessors & mutators
        public int getWidth() {
            return width;
        }
        public int getLength() {
            return length;
        }
        public void setWidth(int w) {
            width = w;
        }
        public void setLength(int l) {
            length = l;
        }

    }


