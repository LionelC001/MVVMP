package com.lionel.mvvm_lifedata_navigation_realmp.common.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GitHubResponse {


    /**
     * total_count : 40
     * incomplete_results : false
     * items : [{"id":3081286,"node_id":"MDEwOlJlcG9zaXRvcnkzMDgxMjg2","name":"Tetris","full_name":"dtrupenn/Tetris","owner":{"login":"dtrupenn","id":872147,"node_id":"MDQ6VXNlcjg3MjE0Nw==","avatar_url":"https://secure.gravatar.com/avatar/e7956084e75f239de85d3a31bc172ace?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png","gravatar_id":"","url":"https://api.github.com/users/dtrupenn","received_events_url":"https://api.github.com/users/dtrupenn/received_events","type":"User"},"private":false,"html_url":"https://github.com/dtrupenn/Tetris","description":"A C implementation of Tetris using Pennsim through LC4","fork":false,"url":"https://api.github.com/repos/dtrupenn/Tetris","created_at":"2012-01-01T00:31:50Z","updated_at":"2013-01-05T17:58:47Z","pushed_at":"2012-01-01T00:37:02Z","homepage":"","size":524,"stargazers_count":1,"watchers_count":1,"language":"Assembly","forks_count":0,"open_issues_count":0,"master_branch":"master","default_branch":"master","score":10.309712}]
     */

    private int total_count;
    private boolean incomplete_results;
    private List<ItemsBean> items;

    public int getTotal_count() {
        return total_count;
    }

    public void setTotal_count(int total_count) {
        this.total_count = total_count;
    }

    public boolean isIncomplete_results() {
        return incomplete_results;
    }

    public void setIncomplete_results(boolean incomplete_results) {
        this.incomplete_results = incomplete_results;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * id : 3081286
         * node_id : MDEwOlJlcG9zaXRvcnkzMDgxMjg2
         * name : Tetris
         * full_name : dtrupenn/Tetris
         * owner : {"login":"dtrupenn","id":872147,"node_id":"MDQ6VXNlcjg3MjE0Nw==","avatar_url":"https://secure.gravatar.com/avatar/e7956084e75f239de85d3a31bc172ace?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png","gravatar_id":"","url":"https://api.github.com/users/dtrupenn","received_events_url":"https://api.github.com/users/dtrupenn/received_events","type":"User"}
         * private : false
         * html_url : https://github.com/dtrupenn/Tetris
         * description : A C implementation of Tetris using Pennsim through LC4
         * fork : false
         * url : https://api.github.com/repos/dtrupenn/Tetris
         * created_at : 2012-01-01T00:31:50Z
         * updated_at : 2013-01-05T17:58:47Z
         * pushed_at : 2012-01-01T00:37:02Z
         * homepage :
         * size : 524
         * stargazers_count : 1
         * watchers_count : 1
         * language : Assembly
         * forks_count : 0
         * open_issues_count : 0
         * master_branch : master
         * default_branch : master
         * score : 10.309712
         */

        private int id;
        private String node_id;
        private String name;
        private String full_name;
        private OwnerBean owner;
        @SerializedName("private")
        private boolean privateX;
        private String html_url;
        private String description;
        private boolean fork;
        private String url;
        private String created_at;
        private String updated_at;
        private String pushed_at;
        private String homepage;
        private int size;
        private int stargazers_count;
        private int watchers_count;
        private String language;
        private int forks_count;
        private int open_issues_count;
        private String master_branch;
        private String default_branch;
        private double score;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNode_id() {
            return node_id;
        }

        public void setNode_id(String node_id) {
            this.node_id = node_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFull_name() {
            return full_name;
        }

        public void setFull_name(String full_name) {
            this.full_name = full_name;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public boolean isPrivateX() {
            return privateX;
        }

        public void setPrivateX(boolean privateX) {
            this.privateX = privateX;
        }

        public String getHtml_url() {
            return html_url;
        }

        public void setHtml_url(String html_url) {
            this.html_url = html_url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isFork() {
            return fork;
        }

        public void setFork(boolean fork) {
            this.fork = fork;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getPushed_at() {
            return pushed_at;
        }

        public void setPushed_at(String pushed_at) {
            this.pushed_at = pushed_at;
        }

        public String getHomepage() {
            return homepage;
        }

        public void setHomepage(String homepage) {
            this.homepage = homepage;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getStargazers_count() {
            return stargazers_count;
        }

        public void setStargazers_count(int stargazers_count) {
            this.stargazers_count = stargazers_count;
        }

        public int getWatchers_count() {
            return watchers_count;
        }

        public void setWatchers_count(int watchers_count) {
            this.watchers_count = watchers_count;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public int getForks_count() {
            return forks_count;
        }

        public void setForks_count(int forks_count) {
            this.forks_count = forks_count;
        }

        public int getOpen_issues_count() {
            return open_issues_count;
        }

        public void setOpen_issues_count(int open_issues_count) {
            this.open_issues_count = open_issues_count;
        }

        public String getMaster_branch() {
            return master_branch;
        }

        public void setMaster_branch(String master_branch) {
            this.master_branch = master_branch;
        }

        public String getDefault_branch() {
            return default_branch;
        }

        public void setDefault_branch(String default_branch) {
            this.default_branch = default_branch;
        }

        public double getScore() {
            return score;
        }

        public void setScore(double score) {
            this.score = score;
        }

        public static class OwnerBean {
            /**
             * login : dtrupenn
             * id : 872147
             * node_id : MDQ6VXNlcjg3MjE0Nw==
             * avatar_url : https://secure.gravatar.com/avatar/e7956084e75f239de85d3a31bc172ace?d=https://a248.e.akamai.net/assets.github.com%2Fimages%2Fgravatars%2Fgravatar-user-420.png
             * gravatar_id :
             * url : https://api.github.com/users/dtrupenn
             * received_events_url : https://api.github.com/users/dtrupenn/received_events
             * type : User
             */

            private String login;
            private int id;
            private String node_id;
            private String avatar_url;
            private String gravatar_id;
            private String url;
            private String received_events_url;
            private String type;

            public String getLogin() {
                return login;
            }

            public void setLogin(String login) {
                this.login = login;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getNode_id() {
                return node_id;
            }

            public void setNode_id(String node_id) {
                this.node_id = node_id;
            }

            public String getAvatar_url() {
                return avatar_url;
            }

            public void setAvatar_url(String avatar_url) {
                this.avatar_url = avatar_url;
            }

            public String getGravatar_id() {
                return gravatar_id;
            }

            public void setGravatar_id(String gravatar_id) {
                this.gravatar_id = gravatar_id;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getReceived_events_url() {
                return received_events_url;
            }

            public void setReceived_events_url(String received_events_url) {
                this.received_events_url = received_events_url;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }
        }
    }
}
