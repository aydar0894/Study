using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Artificial_Neural_Netwok_hierarchy.ANN
{
    public interface Learnable
    {
        void teach(Type learningType);

        float setParams(params object[] p);
    }
}
