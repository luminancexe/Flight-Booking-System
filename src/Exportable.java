public interface Exportable {
    void export(ExportFormat format);
    String exportData(ExportFormat format);
    String generateReport();
    String generateReport(ExportFormat format);
    String generateReport(String criteria);
    String generateReport(String criteria, ExportFormat format);
    String generateReport(String criteria, ExportFormat format, boolean includeDetails);
    String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy);
    String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter);
    String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter, boolean showSummary);
    String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter, boolean showSummary, String additionalInfo);

    String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, boolean showSummary, String additionalInfo);

    String generateReport(String criteria, ExportFormat format,boolean includeDetails, String sortBy, String filter, boolean showSummary, String additionalInfo, boolean includeMetadata);
    String generateReport(String criteria, ExportFormat format, boolean includeDetails, String sortBy, String filter, boolean showSummary, String additionalInfo, boolean includeMetadata, String language);
}