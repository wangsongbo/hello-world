	public InputStream czxyhsExportExcel(int startLine, List<FmisAgreement> list,
			File file, String template, List<String> title) throws Exception{
		return ExportExcel.createExcle(startLine, list, file, template,
				new IExportExcleRowMapper<FmisAgreement>() {
					public void writerRow(HSSFRow row, FmisAgreement rowData) {
						DecimalFormat df = new DecimalFormat("0.00");
						int i = 0;
						ExportExcel.setValue(row.createCell(i++), rowData.getCzAgreementNo());
						ExportExcel.setValue(row.createCell(i++), rowData.getAgreementName());
						ExportExcel.setValue(row.createCell(i++), rowData.getClientName());
						ExportExcel.setValue(row.createCell(i++), rowData.getShipNumber());
						ExportExcel.setValue(row.createCell(i++), rowData.getShipArea());
						ExportExcel.setValue(row.createCell(i++), rowData.getAgreementDetail());
						
						ExportExcel.setValue(row.createCell(i++), df.format(rowData.getSurveyamount().doubleValue()));
						ExportExcel.setValue(row.createCell(i++), df.format(rowData.getGroupAgreeAmount().doubleValue()));
						ExportExcel.setValue(row.createCell(i++), rowData.getBalance());
						ExportExcel.setValue(row.createCell(i++), rowData.getEarnRate());
					}
				}, title);
	}
