class Dest {
    String dst;
    boolean visited;
}
class Solution {
    List<String> result = new ArrayList();
    int totalTickets;
    public List<String> findItinerary(List<List<String>> tickets) {
        totalTickets = tickets.size();
        tickets.sort((a, b) -> a.get(1).compareTo(b.get(1)));
        HashMap<String, List<Dest>> edges = new HashMap();
        for (List<String> ticket : tickets) {
            List<Dest> dests = edges.getOrDefault(ticket.get(0), new ArrayList());
            Dest dest = new Dest();
            dest.dst = ticket.get(1);
            dest.visited = false;
            dests.add(dest);
            edges.put(ticket.get(0), dests);
        }
        dfs(edges, new ArrayList(), "JFK");
        return result;
    }

    public boolean dfs(HashMap<String, List<Dest>> edges, List<List<String>> current, String src) {
        if (current.size() == totalTickets) {
            List<String> ports = current.stream().map(x -> x.get(0)).collect(Collectors.toList());
            ports.add(current.get(current.size() - 1).get(1));
            // System.out.println(ports.toString());
            // System.out.println(result.toString());
            // System.out.println(ports.toString().compareTo(result.toString()));
            result = new ArrayList();
            result.addAll(ports);
            return true;
        }

        List<Dest> dests = edges.getOrDefault(src, new ArrayList());
        for (Dest dest : dests) {
            if (dest.visited) continue;
            List<String> edge = new ArrayList();
            edge.add(src);
            edge.add(dest.dst);
            dest.visited = true;
            current.add(edge);
            if (dfs(edges, current, dest.dst)) return true;
            current.remove(current.size() - 1);
            dest.visited = false;
        }
        return false;
    }
}
