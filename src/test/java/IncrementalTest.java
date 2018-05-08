import controller.MemberController;
import model.Entry;
import model.Member;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import repository.MemberRepository;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

@RunWith(JUnit4.class)
public class IncrementalTest extends TestCase{
    MemberRepository repo;
    MemberController ctrl;

    @Before
    public void setup() {
        repo = new MemberRepository();
        ctrl = new MemberController(repo);
    }

    @Test
    public void testAddMember() {
        Integer sizeBeforeM = ctrl.allMembers().size();

        ctrl.addMember(new Member("Adrian","4"));
        assert(ctrl.allMembers().size() == sizeBeforeM+1);
    }

    @Test
    public void testAddEntryandMember() {
        Integer sizeBeforeM = ctrl.allMembers().size();
        Integer sizeBeforeE = ctrl.allEntries().size();
        ctrl.addMember(new Member("Diana","2"));
        assert(ctrl.allMembers().size() == sizeBeforeM+1);
        ctrl.addEntry(new Entry("cost",10,4,2));
        assert (ctrl.allEntries().size() == sizeBeforeE+1);
    }

    @Test
    public void testGetEntries() {
        Integer sizeBeforeE = ctrl.allEntries().size();
        Integer sizeBeforeM = ctrl.allMembers().size();
        ctrl.addMember(new Member("Cristi","3"));
        assert(ctrl.allMembers().size() == sizeBeforeM+1);
        ctrl.addEntry(new Entry("income",6,7,3));
        assert (ctrl.allEntries().size() == sizeBeforeE+1);

    }
}
