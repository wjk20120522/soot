package soot.jimple.spark.queue;

import soot.util.*;
import soot.jimple.spark.bdddomains.*;
import soot.jimple.spark.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class QobjTrad extends Qobj {
    private ChunkedQueue q = new ChunkedQueue();
    
    public void add(AllocNode _obj) { q.add(_obj); }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { obj.v() },
                                              new PhysicalDomain[] { H1.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at /home/olhotak/soot-2" +
                                               "-jedd/src/soot/jimple/spark/queue/QobjTrad.jedd:36,22"),
                                              in).iterator(new Attribute[] { obj.v() });
        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            for (int i = 0; i < 1; i++) { q.add(tuple[i]); }
        }
    }
    
    public Robj reader() { return new RobjTrad(q.reader()); }
    
    public QobjTrad() { super(); }
}