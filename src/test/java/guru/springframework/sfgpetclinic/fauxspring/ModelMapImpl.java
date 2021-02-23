package guru.springframework.sfgpetclinic.fauxspring;

import lombok.Getter;

import javax.annotation.processing.Generated;
import java.util.HashMap;
import java.util.Map;

public class ModelMapImpl implements Model{

    @Getter
    private final Map<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {
        // do nothing
    }
}
