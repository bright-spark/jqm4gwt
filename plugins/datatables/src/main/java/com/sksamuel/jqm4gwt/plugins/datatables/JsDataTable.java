package com.sksamuel.jqm4gwt.plugins.datatables;

import java.util.List;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayInteger;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.Element;
import com.sksamuel.jqm4gwt.Empty;
import com.sksamuel.jqm4gwt.StrUtils;

public class JsDataTable {

    private JsDataTable() {} // static class

    static {
        defineChangeRowsFunc();
    }

    static class JsSortItem extends JsArrayMixed {

        protected JsSortItem() {}

        public static native JsSortItem create(int col, String jsSortKind) /*-{
            return [col, jsSortKind];
        }-*/;

        public final int getCol() {
            return (int) getNumber(0);
        }

        public final void setCol(int value) {
            set(0, value);
        }

        public final String getJsSortKind() {
            return getString(1);
        }

        public final void setJsSortKind(String value) {
            set(1, value);
        }
    }

    static class JsSortItems extends JsArray<JsSortItem> {
        protected JsSortItems() {}

        /** @param item - if null returns empty array */
        public static native JsSortItems create(JsSortItem item) /*-{
            if(item) return [item];
            else return [];
        }-*/;
    }

    static native void setOrder(Element elt, JsSortItems sorts) /*-{
        var t = $wnd.$(elt).DataTable();
        if (sorts) t.order(sorts).draw();
        else t.order.neutral().draw(); // http://datatables.net/plug-ins/api/order.neutral()
    }-*/;

    static native JsSortItems getOrder(Element elt) /*-{
        return $wnd.$(elt).DataTable().order();
    }-*/;

    static class JsColumn extends JavaScriptObject {

        protected JsColumn() {}

        public static native JsColumn create() /*-{
            return {};
        }-*/;

        public final native String getName() /*-{
            return this.name;
        }-*/;

        public final native void setName(String value) /*-{
            this.name = value;
        }-*/;

        public final native boolean isVisible() /*-{
            return this.visible;
        }-*/;

        public final native void setVisible(boolean value) /*-{
            this.visible = value;
        }-*/;

        public final native boolean isOrderable() /*-{
            return this.orderable;
        }-*/;

        public final native void setOrderable(boolean value) /*-{
            this.orderable = value;
        }-*/;

        public final native boolean isSearchable() /*-{
            return this.searchable;
        }-*/;

        public final native void setSearchable(boolean value) /*-{
            this.searchable = value;
        }-*/;

        public final native String getClassName() /*-{
            return this.className;
        }-*/;

        public final native void setClassName(String value) /*-{
            this.className = value;
        }-*/;

        public final native String getCellType() /*-{
            return this.cellType;
        }-*/;

        public final native void setCellType(String value) /*-{
            this.cellType = value;
        }-*/;

        public final native String getDefaultContent() /*-{
            return this.defaultContent;
        }-*/;

        public final native void setDefaultContent(String value) /*-{
            this.defaultContent = value;
        }-*/;

        public final native String getWidth() /*-{
            return this.width;
        }-*/;

        public final native void setWidth(String value) /*-{
            this.width = value;
        }-*/;

        public final native String getData() /*-{
            if (typeof this.data === 'string') return this.data;
            else return '' + this.data;
        }-*/;

        public final native void setData(String value) /*-{
            this.data = value;
        }-*/;

        public final native int getDataIdx() /*-{
            if (typeof this.data === 'number') return this.data;
            else return -1;
        }-*/;

        public final native void setDataIdx(int value) /*-{
            this.data = value;
        }-*/;
    }

    static class JsColumns extends JsArray<JsColumn> {
        protected JsColumns() {}

        /** @param item - if null returns empty array */
        public static native JsColumns create(JsColumn item) /*-{
            if(item) return [item];
            else return [];
        }-*/;
    }

    /** See <a href="https://datatables.net/reference/option/#Internationalisation">Internationalisation</a> */
    static class JsLanguage extends JavaScriptObject implements Language {

        protected JsLanguage() {}

        public static native JsLanguage create() /*-{
            return {};
        }-*/;

        @Override
        public final native String getDecimal() /*-{
            return this.decimal;
        }-*/;

        @Override
        public final native void setDecimal(String value) /*-{
            this.decimal = value;
        }-*/;

        @Override
        public final native String getThousands() /*-{
            return this.thousands;
        }-*/;

        @Override
        public final native void setThousands(String value) /*-{
            this.thousands = value;
        }-*/;

        @Override
        public final native String getLengthMenu() /*-{
            return this.lengthMenu;
        }-*/;

        @Override
        public final native void setLengthMenu(String value) /*-{
            this.lengthMenu = value;
        }-*/;

        @Override
        public final native String getZeroRecords() /*-{
            return this.zeroRecords;
        }-*/;

        @Override
        public final native void setZeroRecords(String value) /*-{
            this.zeroRecords = value;
        }-*/;

        @Override
        public final native String getInfo() /*-{
            return this.info;
        }-*/;

        @Override
        public final native void setInfo(String value) /*-{
            this.info = value;
        }-*/;

        @Override
        public final native String getInfoEmpty() /*-{
            return this.infoEmpty;
        }-*/;

        @Override
        public final native void setInfoEmpty(String value) /*-{
            this.infoEmpty = value;
        }-*/;

        @Override
        public final native String getInfoFiltered() /*-{
            return this.infoFiltered;
        }-*/;

        @Override
        public final native void setInfoFiltered(String value) /*-{
            this.infoFiltered = value;
        }-*/;

        @Override
        public final native String getLoadingRecords() /*-{
            return this.loadingRecords;
        }-*/;

        @Override
        public final native void setLoadingRecords(String value) /*-{
            this.loadingRecords = value;
        }-*/;

        @Override
        public final native String getProcessing() /*-{
            return this.processing;
        }-*/;

        @Override
        public final native void setProcessing(String value) /*-{
            this.processing = value;
        }-*/;

        @Override
        public final native String getSearch() /*-{
            return this.search;
        }-*/;

        @Override
        public final native void setSearch(String value) /*-{
            this.search = value;
        }-*/;

        @Override
        public final native String getSearchPlaceholder() /*-{
            return this.searchPlaceholder;
        }-*/;

        @Override
        public final native void setSearchPlaceholder(String value) /*-{
            this.searchPlaceholder = value;
        }-*/;

        @Override
        public final native String getUrl() /*-{
            return this.url;
        }-*/;

        @Override
        public final native void setUrl(String value) /*-{
            this.url = value;
        }-*/;

        @Override
        public final String getPaginate() {
            return getPaginateStr();
        }

        @Override
        public final void setPaginate(String value) {
            setPaginateStr(value);
            if (!Empty.is(value)) {
                List<String> lst = StrUtils.commaSplit(value);
                String[] arr = new String[] { null, null, null, null };
                if (lst != null) {
                    for (int i = 0; i < lst.size(); i++) {
                        if (i >= arr.length) break;
                        arr[i] = StrUtils.replaceAllBackslashCommas(lst.get(i).trim());
                    }
                }
                nativeSetPaginate(arr[0], arr[1], arr[2], arr[3]);
            } else {
                nativeSetPaginate(null, null, null, null);
            }
        }

        private final native String getPaginateStr() /*-{
            return this.paginateStr;
        }-*/;

        private final native void setPaginateStr(String value) /*-{
            this.paginateStr = value;
        }-*/;

        private final native void nativeSetPaginate(String sPrev, String sNext,
                                                    String sFirst, String sLast) /*-{
            var empty = true;
            var p = {};
            if (sPrev) {
                empty = false;
                p.previous = sPrev;
            }
            if (sNext) {
                empty = false;
                p.next = sNext;
            }
            if (sFirst) {
                empty = false;
                p.first = sFirst;
            }
            if (sLast) {
                empty = false;
                p.last = sLast;
            }
            if (!empty) this.paginate = p;
        }-*/;
    }

    /** See <a href="https://datatables.net/examples/server_side/pipeline.html">Pipelining data to reduce Ajax calls</a> */
    public static interface AjaxHandler {
        /**
         * @param drawCallback - must be called back when data is ready with JsAjaxRequest as input parameter.
         * @param request - actually it's JsAjaxRequest, so you can cast it safely.
         **/
        void getData(JavaScriptObject/*JsAjaxRequest*/ request, JavaScriptObject drawCallback);
    }

    /** See <a href="https://datatables.net/manual/server-side">Server-side processing</a> */
    /* Example:
       { "draw": 1,
         "columns": [
           {"data":0,"name":"","searchable":true,"orderable":true,"search":{"value":"","regex":false}},
           {"data":1,"name":"","searchable":true,"orderable":true,"search":{"value":"","regex":false}}
         ],
         "order": [ {"column":0,"dir":"asc"} ],
         "start": 0,
         "length": 10,
         "search": {"value":"","regex":false}
       }
    */
    public static class JsAjaxRequest extends JavaScriptObject {

        protected JsAjaxRequest() {}

        public static native JsAjaxRequest create() /*-{
            return {};
        }-*/;

        public final native int getDraw() /*-{
            return this.draw;
        }-*/;

        public final native void setDraw(int value) /*-{
            this.draw = value;
        }-*/;

        public final native int getStart() /*-{
            return this.start;
        }-*/;

        public final native void setStart(int value) /*-{
            this.start = value;
        }-*/;

        public final native int getLength() /*-{
            return this.length;
        }-*/;

        public final native void setLength(int value) /*-{
            this.length = value;
        }-*/;

        public final native String getSearchValue() /*-{
            return this.search.value;
        }-*/;

        public final native void setSearchValue(String v) /*-{
            this.search.value = v;
        }-*/;

        public final native boolean isSearchRegex() /*-{
            return this.search.regex;
        }-*/;

        public final native void setSearchRegex(boolean value) /*-{
            this.search.regex = value;
        }-*/;

        public final native JsOrderItems getOrder() /*-{
            return this.order;
        }-*/;

        public final native void setOrder(JsOrderItems value) /*-{
            this.order = value;
        }-*/;

        public final native JsColItems getColumns() /*-{
            return this.columns;
        }-*/;

        public final native void setColumns(JsColItems value) /*-{
            this.columns = value;
        }-*/;

    }

    public static class JsOrderItem extends JavaScriptObject {

        protected JsOrderItem() {}

        public final native int getCol() /*-{
            return this.column;
        }-*/;

        public final native String getDir() /*-{
            return this.dir;
        }-*/;
    }

    public static class JsOrderItems extends JsArray<JsOrderItem> {
        protected JsOrderItems() {}
    }

    public static class JsColItem extends JavaScriptObject {

        protected JsColItem() {}

        public final native String getData() /*-{
            if (typeof this.data === 'string') return this.data;
            else return '' + this.data;
        }-*/;

        public final native String getName() /*-{
            return this.name;
        }-*/;

        public final native boolean isOrderable() /*-{
            return this.orderable;
        }-*/;

        public final native boolean isSearchable() /*-{
            return this.searchable;
        }-*/;

        public final native String getSearchValue() /*-{
            return this.search.value;
        }-*/;

        public final native boolean isSearchRegex() /*-{
            return this.search.regex;
        }-*/;
    }

    public static class JsColItems extends JsArray<JsColItem> {
        protected JsColItems() {}
    }

    /** See <a href="https://datatables.net/manual/server-side">Server-side processing</a> */
    public static class JsAjaxResponse extends JavaScriptObject {

        protected JsAjaxResponse() {}

        public static native JsAjaxResponse create() /*-{
            return {};
        }-*/;

        public final native int getDraw() /*-{
            return this.draw;
        }-*/;

        public final native void setDraw(int value) /*-{
            this.draw = value;
        }-*/;

        public final native int getRecordsTotal() /*-{
            return this.recordsTotal;
        }-*/;

        public final native void setRecordsTotal(int value) /*-{
            this.recordsTotal = value;
        }-*/;

        public final native int getRecordsFiltered() /*-{
            return this.recordsFiltered;
        }-*/;

        public final native void setRecordsFiltered(int value) /*-{
            this.recordsFiltered = value;
        }-*/;

        public final native JavaScriptObject getData() /*-{
            return this.data;
        }-*/;

        public final native void setData(JavaScriptObject value) /*-{
            this.data = value;
        }-*/;

        public final native String getError() /*-{
            return this.error;
        }-*/;

        public final native void setError(String value) /*-{
            this.error = value;
        }-*/;

    }

    public static class JsAjax extends JavaScriptObject {

        protected JsAjax() {}

        public static native JsAjax create() /*-{
            return {};
        }-*/;

        public final native String getUrl() /*-{
            return this.url;
        }-*/;

        public final native void setUrl(String value) /*-{
            this.url = value;
        }-*/;

        public final native String getDataSrc() /*-{
            return this.dataSrc;
        }-*/;

        public final native void setDataSrc(String value) /*-{
            this.dataSrc = value;
        }-*/;

        public final native String getMethod() /*-{
            return this.method;
        }-*/;

        public final native void setMethod(String value) /*-{
            this.method = value;
        }-*/;

    }

    static class JsLengthMenu extends JsArrayMixed {

        protected JsLengthMenu() {}

        public static native JsLengthMenu create(JsArrayInteger values, JsArrayString names) /*-{
            return [values, names];
        }-*/;

        public static native JsLengthMenu create(JsArrayInteger values) /*-{
            return values;
        }-*/;
    }

    static class JsEnhanceParams extends JavaScriptObject {

        protected JsEnhanceParams() {}

        public static native JsEnhanceParams create() /*-{
            return {};
        }-*/;

        public final native boolean isPaging() /*-{
            return this.paging;
        }-*/;

        public final native void setPaging(boolean value) /*-{
            this.paging = value;
        }-*/;

        public final native boolean isLengthChange() /*-{
            return this.lengthChange;
        }-*/;

        public final native void setLengthChange(boolean value) /*-{
            this.lengthChange = value;
        }-*/;

        public final native JsLengthMenu getLengthMenu() /*-{
            return this.lengthMenu;
        }-*/;

        public final native void setLengtMenu(JsLengthMenu value) /*-{
            this.lengthMenu = value;
        }-*/;

        public final native boolean isInfo() /*-{
            return this.info;
        }-*/;

        public final native void setInfo(boolean value) /*-{
            this.info = value;
        }-*/;

        public final native boolean isOrdering() /*-{
            return this.ordering;
        }-*/;

        public final native void setOrdering(boolean value) /*-{
            this.ordering = value;
        }-*/;

        public final native boolean isSearching() /*-{
            return this.searching;
        }-*/;

        public final native void setSearching(boolean value) /*-{
            this.searching = value;
        }-*/;

        public final native JsSortItems getOrder() /*-{
            return this.order;
        }-*/;

        public final native void setOrder(JsSortItems value) /*-{
            this.order = value;
        }-*/;

        public final native JsColumns getColumns() /*-{
            return this.columns;
        }-*/;

        public final native void setColumns(JsColumns value) /*-{
            this.columns = value;
        }-*/;

        public final native boolean isScrollX() /*-{
            return this.scrollX;
        }-*/;

        public final native void setScrollX(boolean value) /*-{
            this.scrollX = value;
        }-*/;

        public final native String getScrollY() /*-{
            return this.scrollY;
        }-*/;

        public final native void setScrollY(String value) /*-{
            this.scrollY = value;
        }-*/;

        public final native boolean isScrollCollapse() /*-{
            return this.scrollCollapse;
        }-*/;

        public final native void setScrollCollapse(boolean value) /*-{
            this.scrollCollapse = value;
        }-*/;

        public final native JsLanguage getLanguage() /*-{
            return this.language;
        }-*/;

        public final native void setLanguage(JsLanguage value) /*-{
            this.language = value;
        }-*/;

        public final native String getPagingType() /*-{
            return this.pagingType;
        }-*/;

        public final native void setPagingType(String value) /*-{
            this.pagingType = value;
        }-*/;

        public final native String getAjax() /*-{
            if (typeof this.ajax === 'string') return this.ajax;
            else return null;
        }-*/;

        public final native void setAjax(String value) /*-{
            this.ajax = value;
        }-*/;

        public final native JsAjax getAjaxObj() /*-{
            if (typeof this.ajax === 'string') return { url: this.ajax };
            else if (typeof this.ajax === 'function') return null;
            else return this.ajax;
        }-*/;

        public final native void setAjaxObj(JsAjax value) /*-{
            this.ajax = value;
        }-*/;

        public final native void setAjaxHandler(final AjaxHandler handler) /*-{
            this.ajax = function ( request, drawCallback, settings ) {
                handler.@com.sksamuel.jqm4gwt.plugins.datatables.JsDataTable.AjaxHandler::getData(
                    Lcom/google/gwt/core/client/JavaScriptObject;Lcom/google/gwt/core/client/JavaScriptObject;)
                    (request, drawCallback);
            };
        }-*/;

        public final native boolean isServerSide() /*-{
            return this.serverSide;
        }-*/;

        public final native void setServerSide(boolean value) /*-{
            this.serverSide = value;
        }-*/;

        public final native boolean isDeferRender() /*-{
            return this.deferRender;
        }-*/;

        public final native void setDeferRender(boolean value) /*-{
            this.deferRender = value;
        }-*/;

        public final native boolean isProcessing() /*-{
            return this.processing;
        }-*/;

        public final native void setProcessing(boolean value) /*-{
            this.processing = value;
        }-*/;

        public final native boolean isStateSave() /*-{
            return this.stateSave;
        }-*/;

        public final native void setStateSave(boolean value) /*-{
            this.stateSave = value;
        }-*/;

        public final native int getStateDuration() /*-{
            return this.stateDuration;
        }-*/;

        public final native void setStateDuration(int value) /*-{
            this.stateDuration = value;
        }-*/;

        public final native boolean isAutoWidth() /*-{
            return this.autoWidth;
        }-*/;

        public final native void setAutoWidth(boolean value) /*-{
            this.autoWidth = value;
        }-*/;

        public final native void setInitComplete(final JsCallback done) /*-{
            this.initComplete = function(settings, json) {
                done.@com.sksamuel.jqm4gwt.plugins.datatables.JsDataTable.JsCallback::onSuccess()();
            };
        }-*/;

        public final native void setRowCallback(final JsRowCallback callback) /*-{
            this.rowCallback = function( row, data ) {
                callback.@com.sksamuel.jqm4gwt.plugins.datatables.JsDataTable.JsRowCallback::onRow(
                    Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;)
                    (row, data);
            };
        }-*/;

    }

    static interface JsCallback {
        void onSuccess();
    }

    static interface JsRowCallback {
        void onRow(Element row, JavaScriptObject data);
    }

    static native void enhance(Element elt, JsEnhanceParams params) /*-{
        if (params) $wnd.$(elt).DataTable(params); // $wnd.$.parseJSON(jsonParams)
        else $wnd.$(elt).DataTable();
    }-*/;

    static native void setDataRoleNone(Element elt) /*-{
        var i = $wnd.$(elt);
        i.attr('data-role', 'none');
        i.find('*').attr('data-role', 'none');
    }-*/;

    static native void ajaxReload(Element elt, boolean resetPaging) /*-{
        $wnd.$(elt).DataTable().ajax.reload( null, resetPaging );
    }-*/;

    /** Invalidate all rows and redraw, useful after data changes, see addRow() */
    static native void rowsInvalidate(Element elt, boolean resetPaging) /*-{
        $wnd.$(elt).DataTable().rows().invalidate().draw(resetPaging);
    }-*/;

    static native JavaScriptObject getData(Element elt) /*-{
        return $wnd.$(elt).DataTable().data();
    }-*/;

    static native void clearData(Element elt) /*-{
        $wnd.$(elt).DataTable().clear();
    }-*/;

    static native void addRow(Element elt, JavaScriptObject newRow) /*-{
        $wnd.$(elt).DataTable().row.add(newRow);
    }-*/;

    static native void removeRow(Element elt, int rowIndex) /*-{
        $wnd.$(elt).DataTable().row(rowIndex).remove();
    }-*/;

    public static interface CellClickHandler {
        /**
         * @return - if true then event.stopPropagation() will be called.
         */
        boolean onClick(Element elt, JavaScriptObject rowData, int rowIndex);
    }

    /**
     * @param cellWidget - for example "button", "input[type='checkbox']"
     */
    static native void addCellClickHandler(Element elt, String cellWidget, CellClickHandler handler) /*-{
        var t = $wnd.$(elt);
        t.children('tbody').first().on('click', cellWidget, function(event) {
            var row = t.DataTable().row($wnd.$(this).closest('tr'));
            var rslt = handler.@com.sksamuel.jqm4gwt.plugins.datatables.JsDataTable.CellClickHandler::onClick(
              Lcom/google/gwt/dom/client/Element;Lcom/google/gwt/core/client/JavaScriptObject;I)
              (this, row.data(), row.index());
            if (rslt) event.stopPropagation();
        });
    }-*/;

    /** Predefined class for cell checkboxes, which are going to select/unselect rows. */
    static final String CHECKBOX_ROWSEL = "checkbox-rowsel";

    private static native void defineChangeRowsFunc() /*-{
        if ($wnd.dataTableChangeRows) return;
        $wnd.dataTableChangeRows = function(rows, selected, elt) {
            if (rows) {
                if (selected) {
                    rows.addClass('selected');
                    rows.find('.checkbox-rowsel').prop('checked', true);
                } else {
                    rows.removeClass('selected');
                    rows.find('.checkbox-rowsel').prop('checked', false);
                }
                var rowSelChanged = $wnd.$(elt).closest('table').data('rowSelChanged');
                if (rowSelChanged) {
                    rows.each(function(index) {
                        rowSelChanged(this, selected);
                    });
                }
            }
        };
    }-*/;

    static interface JsRowSelect {
        void onRowSelChanged(Element row, boolean selected, JavaScriptObject rowData);
    }

    static native void setRowSelChanged(final Element tableElt, JsRowSelect handler) /*-{
        $wnd.$(tableElt).data('rowSelChanged', function(row, selected) {
            var rowData = $wnd.$(tableElt).DataTable().row(row).data();
            handler.@com.sksamuel.jqm4gwt.plugins.datatables.JsDataTable.JsRowSelect::onRowSelChanged(
              Lcom/google/gwt/dom/client/Element;ZLcom/google/gwt/core/client/JavaScriptObject;)
              (row, selected, rowData);
        });
    }-*/;

    static native void switchOffSingleRowSelect(Element elt) /*-{
        var t = $wnd.$(elt);
        t.children('tbody').off('click.singlerowsel', 'tr');
    }-*/;

    static native void switchOnSingleRowSelect(Element elt) /*-{
        var t = $wnd.$(elt);
        t.children('tbody').on('click.singlerowsel', 'tr', function() {
            var $this = $wnd.$(this);
            if ($this.hasClass('selected')) {
                $wnd.dataTableChangeRows($this, false, elt);
            } else {
                $wnd.dataTableChangeRows(t.DataTable().$('tr.selected'), false, elt);
                $wnd.dataTableChangeRows($this, true, elt);
            }
        });
    }-*/;

    static native void switchOffMultiRowSelect(Element elt) /*-{
        var t = $wnd.$(elt);
        t.children('tbody').off('click.multirowsel', 'tr');
    }-*/;

    static native void switchOnMultiRowSelect(Element elt) /*-{
        var t = $wnd.$(elt);
        t.children('tbody').on('click.multirowsel', 'tr', function() {
            var $this = $wnd.$(this);
            if ($this.hasClass('selected')) {
                $wnd.dataTableChangeRows($this, false, elt);
            } else {
                $wnd.dataTableChangeRows($this, true, elt);
            }
        });
    }-*/;

    static native void changeRow(Element cellElt, boolean selected) /*-{
        $wnd.dataTableChangeRows($wnd.$(cellElt).closest('tr'), selected, cellElt);
    }-*/;

    static native void selectOneRowOnly(Element cellElt) /*-{
        var rows = $wnd.$(cellElt).closest('tr');
        if (rows.length) {
            var row = rows.first();
            $wnd.dataTableChangeRows(row.closest('tbody').children('tr.selected'), false, cellElt);
            $wnd.dataTableChangeRows(row, true, cellElt);
        }
    }-*/;

    static native void unselectAllRows(Element tableElt) /*-{
        var t = $wnd.$(tableElt);
        $wnd.dataTableChangeRows(t.DataTable().$('tr.selected'), false, tableElt);
    }-*/;

    static native JsArrayInteger getSelRowIndexes(Element tableElt) /*-{
        return $wnd.$(tableElt).DataTable().rows('tr.selected').indexes().toArray();
    }-*/;

    static native JsArray<JavaScriptObject> getSelRowDatas(Element tableElt) /*-{
        return $wnd.$(tableElt).DataTable().rows('tr.selected').data().toArray();
    }-*/;

    public static interface RowDetailsRenderer {

        String getHtml(JavaScriptObject rowData, int rowIndex);
    }

    static native void addRowDetailsRenderer(Element elt, RowDetailsRenderer renderer) /*-{
        // Add event listener for opening and closing details
        var t = $wnd.$(elt);
        t.children('tbody').first().on('click', 'td.details-control', function(event) {
            var tr = $wnd.$(this).closest('tr');
            var row = t.DataTable().row(tr);

            if (row.child.isShown()) {
                // This row is already open - close it
                row.child.hide();
                tr.removeClass('shown');
            } else {
                // Open this row
                var html = renderer.@com.sksamuel.jqm4gwt.plugins.datatables.JsDataTable.RowDetailsRenderer::getHtml(
                    Lcom/google/gwt/core/client/JavaScriptObject;I)(row.data(), row.index());
                row.child(html).show();
                tr.addClass('shown');
            }
            event.stopPropagation(); // no row selection is needed
        });
    }-*/;

    static native JavaScriptObject getCellData(Element elt, int rowIndex, int colIndex) /*-{
        var v = $wnd.$(elt).DataTable().cells(rowIndex, colIndex).data();
        return v.toArray();
    }-*/;

    static native JavaScriptObject getCellData(Element elt, int rowIndex, String colName) /*-{
        var v = $wnd.$(elt).DataTable().cells(rowIndex, colName + ':name').data();
        return v.toArray();
    }-*/;

}