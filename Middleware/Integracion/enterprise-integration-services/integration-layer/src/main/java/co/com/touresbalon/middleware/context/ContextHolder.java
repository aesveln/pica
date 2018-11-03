package co.com.touresbalon.middleware.context;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ContextHolder {

	private static final Map<String, Map<String, Object>> store = new HashMap<>();

	public ContextHolder() {
		super();
	}

	public void initTransactionContext(final String txId) {
		store.put(txId, new HashMap<>());
	}

	public void releaseTransactionContext(final String txId) {
		store.remove(txId);
	}

	public void putAttribute(final String txId, final String key, final Object value) {
		if (store.containsKey(txId))
			store.get(txId).put(key, value);
	}

	public Object getAttribute(final String txId, final String key) {
		if (store.containsKey(txId))
			return store.get(txId).get(key);
		else
			return null;
	}

}