package lab8;
/**
 * Name: Sean Stille
 * Description: Lab 8
 * Date: 4/16/22
 * Bugs: Does not function past lambda value 0.5. Testing not implemented
 * Reflection:  I had quite a bit of trouble with this one, some of which I wasn't sure how to solve. 
 *              Firstly, I haven't been able to get the code to work for lambda values past 0.5.
 *              When I try to do so, something about the put method in LinearProbingHashTable goes into an infinite loop.
 *              Additionally, I was trying to implement unit testing, but after I pressed the testing button it went to a new
 *              screen but didn't give me the testing icons on my code, so I wasn't sure where to go from there.
 *              On Monday I'm going to try to come to office hours and I wanted to go over some of these errors and see 
 *              if we could troubleshoot them.
 */
public class App {
    public static void main(String[] args) throws Exception {
        new HashMapPlayground().printExperimentalResultsTable();
        
    }
}
