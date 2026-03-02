public class DefaultSimilarityChecker implements SimilarityChecker {

    @Override
    public int score(Submission s) {
        return (s.code.contains("class") ? 12 : 40);
    }
}
