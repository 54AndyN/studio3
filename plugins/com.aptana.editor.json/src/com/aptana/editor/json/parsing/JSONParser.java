package com.aptana.editor.json.parsing;

import java.util.ArrayList;
import com.aptana.parsing.ast.IParseRootNode;
import beaver.*;
import com.aptana.parsing.IParser;
import com.aptana.parsing.ast.IParseNode;
import com.aptana.editor.json.parsing.ast.*;
import com.aptana.parsing.IParseState;

/**
 * This class is a LALR parser generated by
 * <a href="http://beaver.sourceforge.net">Beaver</a> v0.9.6.1
 * from the grammar specification "JSON.beaver".
 */
@SuppressWarnings({ "unchecked", "rawtypes", "nls" })
public class JSONParser extends Parser implements IParser {

	static final ParsingTables PARSING_TABLES = new ParsingTables(
		"U9oDKjbomZ0CN1DeqtB4X90UWVB40pmMlg1Vrl$jHU#M7khQA859OO9dTbQhh6L5De0h#KK" +
		"BVTHnY117E4RpdnwWWxJILKE01WxGHYmYDyXKd#8C9qXKdIj7w2A6XLizmlZzTV$DrIphcA" +
		"vcfQl3kfQLNKTWVxbstIQ5MhjY#bhiLjWrCBn6iQOkhWBNIFbIUQOyT$#bSQWyLiwsr4dtE" +
		"S$1TLlQEzs8ypCkIfv9IGzN93$oBL#ob4$va7TvarVcNeXduiax5iG3SK$SoQqyCfbmjeO0" +
		"Psbs8b9OtfBbFVKy3ASUSFer8l3l8c4k$GExpay7");

    // suppress parser error reporting and let the custom error recovery mechanism handle it
    private static class JSONEvents extends Events
    {
        public void scannerError(Scanner.Exception e)
        {
        }

        public void syntaxError(Symbol token)
        {
        }

        public void unexpectedTokenRemoved(Symbol token)
        {
        }

        public void missingTokenInserted(Symbol token)
        {
        }

        public void misspelledTokenReplaced(Symbol token)
        {
        }

        public void errorPhraseRemoved(Symbol error)
        {
        }
    }

    /*
     * (non-Javadoc)
     * @see com.aptana.parsing.IParser#parse(com.aptana.parsing.IParseState)
     */
    public synchronized IParseRootNode parse(IParseState parseState) throws java.lang.Exception
    {
        JSONScanner scanner = new JSONScanner();

        // grab source
        char[] characters = parseState.getSource();

        // make sure we have some source
        String source = (characters != null) ? new String(characters) : "";

        // send source to the scanner
        scanner.setSource(source);

        // parse
        IParseRootNode result = (IParseRootNode) parse(scanner);

        // save reference to result
        parseState.setParseResult(result);

        return result;
    }

	public JSONParser() {
		super(PARSING_TABLES);


        report = new JSONEvents();
	}

	protected Symbol invokeReduceAction(int rule_num, int offset) {
		switch(rule_num) {
			case 0: // JSON = Value.v
			{
					final Symbol _symbol_v = _symbols[offset + 1];
					final JSONNode v = (JSONNode) _symbol_v.value;
					
            return new JSONParseRootNode(new Symbol[] { v });
			}
			case 1: // JSON = 
			{
					
            return new JSONParseRootNode();
			}
			case 3: // Value = NUMBER.n
			{
					final Symbol _symbol_n = _symbols[offset + 1];
					final String n = (String) _symbol_n.value;
					
    		return new JSONNumberNode(n);
			}
			case 6: // Value = TRUE
			{
					
    		return new JSONTrueNode();
			}
			case 7: // Value = FALSE
			{
					
    		return new JSONFalseNode();
			}
			case 8: // Value = NULL
			{
					
    		return new JSONNullNode();
			}
			case 9: // String = STRING_DOUBLE.s
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final String s = (String) _symbol_s.value;
					
    		return new JSONStringNode(s.substring(1, s.length() - 1));
			}
			case 10: // String = STRING_SINGLE.s
			{
					final Symbol _symbol_s = _symbols[offset + 1];
					final String s = (String) _symbol_s.value;
					
    		return new JSONStringNode(s.substring(1, s.length() - 1));
			}
			case 11: // Object = LCURLY RCURLY
			{
					
            return new JSONObjectNode();
			}
			case 12: // Object = LCURLY Entries.e RCURLY
			{
					final Symbol _symbol_e = _symbols[offset + 2];
					final ArrayList _list_e = (ArrayList) _symbol_e.value;
					final JSONNode[] e = _list_e == null ? new JSONNode[0] : (JSONNode[]) _list_e.toArray(new JSONNode[_list_e.size()]);
					
            JSONObjectNode object = new JSONObjectNode();

            for (IParseNode node : e)
            {
                object.addChild(node);
            }

            return object;
			}
			case 13: // Entries = Entries COMMA Entry
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3].value); return _symbols[offset + 1];
			}
			case 14: // Entries = Entry
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
			}
			case 15: // Entry = PROPERTY.p COLON.c Value.v
			{
					final Symbol _symbol_p = _symbols[offset + 1];
					final String p = (String) _symbol_p.value;
					final Symbol c = _symbols[offset + 2];
					final Symbol _symbol_v = _symbols[offset + 3];
					final JSONNode v = (JSONNode) _symbol_v.value;
					
            JSONEntryNode entry = new JSONEntryNode(c);
            JSONStringNode property = new JSONStringNode(p.substring(1, p.length() - 1));

            property.setLocation(_symbol_p.getStart(), _symbol_p.getEnd());

            entry.addChild(property);
            entry.addChild(v);

            return entry;
			}
			case 16: // Array = LBRACKET RBRACKET
			{
					
            return new JSONArrayNode();
			}
			case 17: // Array = LBRACKET Values.v RBRACKET
			{
					final Symbol _symbol_v = _symbols[offset + 2];
					final ArrayList _list_v = (ArrayList) _symbol_v.value;
					final JSONNode[] v = _list_v == null ? new JSONNode[0] : (JSONNode[]) _list_v.toArray(new JSONNode[_list_v.size()]);
					
            JSONArrayNode array = new JSONArrayNode();

            for (IParseNode node : v)
            {
                array.addChild(node);
            }

            return array;
			}
			case 18: // Values = Values COMMA Value
			{
					((ArrayList) _symbols[offset + 1].value).add(_symbols[offset + 3].value); return _symbols[offset + 1];
			}
			case 19: // Values = Value
			{
					ArrayList lst = new ArrayList(); lst.add(_symbols[offset + 1].value); return new Symbol(lst);
			}
			case 2: // Value = String
			case 4: // Value = Object
			case 5: // Value = Array
			{
				return _symbols[offset + 1];
			}
			default:
				throw new IllegalArgumentException("unknown production #" + rule_num);
		}
	}
}
