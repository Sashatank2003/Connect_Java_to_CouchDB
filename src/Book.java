//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;
@JsonInclude(Include.NON_NULL)
class Book {
    @JsonProperty("_id")
    private String id;
    @JsonProperty("_rev")
    private String revision;
    private String info;
    Book() {
    }
    public String getId() {
        return this.id;
    }
    public String getRevision() {
        return this.revision;
    }
    public String getInfo() {
        return this.info;
    }
    public void setId(String id) {
        this.id = id;
    }
    public void setRevision(String revision) {
        this.revision = revision;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public String toString() {
        return this.info;
    }
    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("_id", id);
        map.put("_rev", revision);
        map.put("info", info);
        return map;
    }
}
