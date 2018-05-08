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
        Integer sizeBeforeM = ctrl.allMembers().size();

        ctrl.addMember(new Member("Adrian","4"));
        assert(ctrl.allMembers().size() == sizeBeforeM+1);
    }

    @Test
    public void addEntryandMemberTest() {
        Integer sizeBeforeM = ctrl.allMembers().size();
        Integer sizeBeforeE = ctrl.allEntries().size();
        ctrl.addMember(new Member("Diana","2"));
        assert(ctrl.allMembers().size() == sizeBeforeM+1);
        ctrl.addEntry(new Entry("cost",10,4,2));
        assert (ctrl.allEntries().size() == sizeBeforeE+1);
    }

    @Test
    public void getEntries() {
        Integer sizeBeforeE = ctrl.allEntries().size();
        Integer sizeBeforeM = ctrl.allMembers().size();
        ctrl.addMember(new Member("Cristi","3"));
        assert(ctrl.allMembers().size() == sizeBeforeM+1);
        ctrl.addEntry(new Entry("income",6,7,3));
        assert (ctrl.allEntries().size() == sizeBeforeE+1);

    }
}
