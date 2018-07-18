package com.qxb.student.common.module.bean.attr;

public class ShareAttr {


    public ShareAttr(String title, String titleUrl, String text, String imageUrl, String url) {

    }

    public static class Builder {
        private String title;
        private String titleUrl;
        private String text;
        private String imageUrl;
        private String url;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder titleUrl(String titleUrl) {
            this.titleUrl = titleUrl;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }

        public Builder imageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            return this;
        }

        public Builder url(String url) {
            this.url = url;
            return this;
        }

        public ShareAttr build() {
            return new ShareAttr(title, titleUrl, text, imageUrl, url);
        }

    }
}
