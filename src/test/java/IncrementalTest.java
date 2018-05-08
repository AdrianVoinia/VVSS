import controller.MemberController;
import model.Entry;
import model.Member;
import repository.MemberRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class IncrementalTest{
    MemberRepository repo;
    MemberController ctrl;

    @Before
    public void setup() {
        repo = new MemberRepository();
        ctrl = new MemberController(repo);
    }

    @Test
    public void addMemberTest() {
        ctrl.addMember(new Member("Adrian","4"));
        assert(ctrl.allEntries().size() == 1);
    }

    @Test
    public void addEntryandMemberTest() {
        System.out.println(ctrl.allEntries().size());
        ctrl.addMember(new Member("Diana","2"));
        System.out.println(ctrl.allEntries().size());
        assert(ctrl.allEntries().size() == 1);
        ctrl.addEntry(new Entry("cost",10,4,2));
        assert (ctrl.allEntries().size() == 1);
    }

    @Test
    public void getEntries() {
        Integer sizeBefore = ctrl.allEntries().size();
        ctrl.addMember(new Member("Cristi","3"));
        assert(ctrl.allEntries().size() == 1);
        ctrl.addEntry(new Entry("income",6,7,3));
        assert (ctrl.allEntries().size() == 1);

        Integer sizeAfter = ctrl.allEntries().size();
        assert (sizeAfter == sizeBefore+1);
    }
}
