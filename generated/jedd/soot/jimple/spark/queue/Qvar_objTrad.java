package soot.jimple.spark.queue;

import soot.util.*;
import soot.jimple.spark.bdddomains.*;
import soot.jimple.spark.*;
import soot.jimple.toolkits.callgraph.*;
import soot.*;
import soot.util.queue.*;
import jedd.*;
import java.util.*;

public class Qvar_objTrad extends Qvar_obj {
    private ChunkedQueue q = new ChunkedQueue();
    
    public void add(VarNode _var, AllocNode _obj) {
        q.add(_var);
        q.add(_obj);
    }
    
    public void add(final jedd.internal.RelationContainer in) {
        Iterator it =
          new jedd.internal.RelationContainer(new Attribute[] { obj.v(), var.v() },
                                              new PhysicalDomain[] { H1.v(), V1.v() },
                                              ("in.iterator(new jedd.Attribute[...]) at /home/olhotak/soot-2" +
                                               "-jedd/src/soot/jimple/spark/queue/Qvar_objTrad.jedd:37,22"),
                                              in).iterator(new Attribute[] { var.v(), obj.v() });
        while (it.hasNext()) {
            Object[] tuple = (Object[]) it.next();
            for (int i = 0; i < 2; i++) { q.add(tuple[i]); }
        }
    }
    
    public Rvar_obj reader() { return new Rvar_objTrad(q.reader()); }
    
    public Qvar_objTrad() { super(); }
}