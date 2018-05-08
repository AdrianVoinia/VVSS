package exceptions;

import controller.MemberController;
import repository.MemberRepository;
import org.junit.*;

import controller.MemberController;
import model.Entry;
import model.Member;
import repository.MemberRepository;

public class BigBangIntegration {
    MemberRepository repo;
    MemberController ctrl;

    @org.junit.Before
    public void setup() {
        repo = new MemberRepository();
        ctrl = new MemberController(repo);
    }

    @org.junit.Test
    public void addMember() {
        ctrl.addMember(new Member("Radu","1"));
        assert(ctrl.allEntries().size() == 1);
        ctrl.addMember(new Member("Adrian","4"));
        assert(ctrl.allEntries().size() == 2);
    }

    @org.junit.Test
    public void addEntry() {
        ctrl.addEntry(new Entry("cost",10,4,4));
        assert (ctrl.allEntries().size() == 1);
    }

    @org.junit.Test
    public void getEntries() {
        ctrl.addEntry(new Entry("type1",21,3,2));
        ctrl.addEntry(new Entry("type2",23,3,1));

        Integer size = ctrl.allEntries().size();
        assert (size == 3 || size == 2);
    }

    @org.junit.Test
    public void runBigBangIntegration() {
        addMember();
        addEntry();
        getEntries();
    }

}
