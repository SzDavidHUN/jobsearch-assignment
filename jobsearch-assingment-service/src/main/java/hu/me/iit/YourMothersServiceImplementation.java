package hu.me.iit;

import org.springframework.stereotype.Component;

@Component
public class YourMothersServiceImplementation implements YourMothersService {
    @Override
    public String getStuff() {
        return "LOL";
    }
}
